package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    int scoreTeamA=0;
    int scoreTeamB=0;
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addTwoForTeamA(View view)
    {
         scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }
    public void addThreeForTeamA(View view)
    {
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }
    public void addOneForTeamA(View view)
    {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addTwoForTeamB(View view)
    {
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    public void addThreeForTeamB(View view)
    {
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void addOneForTeamB(View view)
    {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }
    public void resetZero(View view)
    {
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}