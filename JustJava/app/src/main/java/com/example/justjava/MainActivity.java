package com.example.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox WhippedCreamCB = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = WhippedCreamCB.isChecked();
        CheckBox ChocolateCB = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCB.isChecked();
        EditText  name = (EditText) findViewById(R.id.user_name);
        String name_text=name.getText().toString();
        int price=calculatePrice(hasChocolate,hasWhippedCream);
        String priceMessage=createOrderSummary(price,hasWhippedCream,hasChocolate,name_text);
       displayMessage(priceMessage);

    }
    public void EmailOrder(View view)
    {
        CheckBox WhippedCreamCB = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = WhippedCreamCB.isChecked();
        CheckBox ChocolateCB = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCB.isChecked();
        EditText  name = (EditText) findViewById(R.id.user_name);
        String name_text=name.getText().toString();
        int price=calculatePrice(hasChocolate,hasWhippedCream);
        String priceMessage=createOrderSummary(price,hasWhippedCream,hasChocolate,name_text);
        composeEmail(priceMessage,name_text);
    }
    /**
     * increament method
     */
    public void increment(View view)
    {

        quantity=quantity+1;
        if(quantity>100)
        {
            quantity=100;
            Toast.makeText(this,getString(R.string.upper_limit),Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }
    /**
     * decreament method
     */
    public void decrement(View view)
    {
        quantity=quantity-1;
        if(quantity<1)
        {
            quantity=1;
            Toast.makeText(this,getString(R.string.lower_limit),Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice(boolean hasChocolate,boolean hasWhippedCream) {
        int price = 5;
        if(hasWhippedCream)
            price+=1;
        if(hasChocolate)
            price+=2;
        price=price*quantity;
        return price;
    }

    /**
     * createOrderSummary returns the summary of the order
     * @param price is the total price
     * @param hasChocolate if chocolate topping is required
     * @param hasWhippedCream if whipped cream as a topping is required
     * @param name_text name of the customer
     * @return order summary
     */
    private String createOrderSummary(int price,boolean hasWhippedCream,boolean hasChocolate,String name_text)
    {
        String summary=getString(R.string.customer_name)+name_text+"\n"+getString(R.string.addWhippedCream)+hasWhippedCream+"\n"+getString(R.string.addChocolate)+hasChocolate+"\n"+getString(R.string.quantityreq)+quantity+"\n"+getString(R.string.cost)+price+"\n"+getString(R.string.thank_you);
        return summary;
    }
    public void composeEmail( String subject,String name) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject)+ name);
        intent.putExtra(Intent.EXTRA_TEXT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}