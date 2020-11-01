package com.example.dervis.americanfootball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //score textView for each team
    TextView TextViewTeamAScore;
    TextView TextViewTeamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initiate The Score TextViews
        TextViewTeamAScore = findViewById(R.id.textView_team_a);
        TextViewTeamBScore = findViewById(R.id.textView_team_b);
    }

    //this method although it's complex, it helps with removing allot of redundant code, instead of
    //having eight methods one is enough the job.
    public void scoreButtonClick(View v) {
        //Convert the view to a Button to Access its text
        Button ButtonX = (Button) v;
        //extract the text from the button to know what score value to add
        String ButtonXText = ButtonX.getText().toString().toLowerCase();

        //Hold The Text View Of the Pressed Button's Team
        TextView TeamXScore;

        //Decide Which Team's Score Should Be The subject of The Actions To Follow.
        //the team's score is known through the linearLayout containing the button that is pressed
        //I gave each linearLayout an id corresponding with its team, that means there are two linearLayouts
        //      1.LinearLayout_team_a
        //      2.LinearLayout_team_b
        if (v.getParent() == findViewById(R.id.linearLayout_team_a))
            TeamXScore = TextViewTeamAScore;
        else
            TeamXScore = TextViewTeamBScore;

        //get the current score of the team
        int currentScore = Integer.parseInt(TeamXScore.getText().toString());

        //increase the score based on the text of the button
        if (ButtonXText.equals(getString(R.string.touchdown).toLowerCase()))
            currentScore += AmericanFootball.Scores.TOUCHDOWN;
        else if (ButtonXText.equals(getString(R.string.field_goal).toLowerCase()))
            currentScore += AmericanFootball.Scores.FIELD_GOAL;
        else if (ButtonXText.equals(getString(R.string.safety).toLowerCase()))
            currentScore += AmericanFootball.Scores.SAFETY;
        else if (ButtonXText.equals(getString(R.string.a_point).toLowerCase()))
            currentScore += AmericanFootball.Scores.A_POINT;

        //set the text of the score
        TeamXScore.setText(String.valueOf(currentScore));
    }

    //reset all scores
    public void ResetButtonClick(View v) {
        TextViewTeamAScore.setText(String.valueOf(0));
        TextViewTeamBScore.setText(String.valueOf(0));
    }
}