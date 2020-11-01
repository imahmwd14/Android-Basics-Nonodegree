package com.example.dervis.javaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();
    private List<RadioButton> radioButtons = new ArrayList<>();
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private TextView theQuestionTextView;
    private LinearLayout checkBoxesLinearLayout;
    private RadioGroup radioGroup;
    private EditText editText;

    private Question q;

    private int questionsAsked = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theQuestionTextView = findViewById(R.id.the_question);
        checkBoxesLinearLayout = findViewById(R.id.checkboxes_listview);
        radioGroup = findViewById(R.id.radiogroup);
        editText = findViewById(R.id.editText);

        radioButtons = Arrays.asList((RadioButton) findViewById(R.id.radioButton),
                (RadioButton) findViewById(R.id.radioButton2));

        checkBoxes = Arrays.asList((CheckBox) findViewById(R.id.checkBox),
                (CheckBox) findViewById(R.id.checkBox2),
                (CheckBox) findViewById(R.id.checkBox3),
                (CheckBox) findViewById(R.id.checkBox4));

        InitializeTheQuestions();
    }

    public void NextButton(View v) {
        //check if the answer/s is/are correct.
        //if the field q is null that means either questions haven't begun or just ended.
        if (q != null) {
            checkTheUsersAnswer();
        }

        //display a new question if there is more
        //if questionsAsked reaches the size of the list of questions that means there are no more
        // questions to display because questionsAsked is also used an an index number.
        if (questionsAsked != questions.size()) {
            //get a new q object
            q = questions.get(questionsAsked);

            setQuestionText(q);

            //all the modular views are hidden because only one of them should be seen! and the will
            //be chosen after some logic.
            hideAndResetAllModularViews();

            switch (q.QuestionType) {
                case CheckBox:
                    MakeViewVisible(checkBoxesLinearLayout);

                    //align the list of choices with the list of checkBoxes becuase aligning them
                    //helps with answer checking.
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        checkBoxes.get(i).setText(q.Choices.get(i));
                    }
                    break;
                case RadioButton:
                    MakeViewVisible(radioGroup);

                    for (int i = 0; i < radioButtons.size(); i++) {
                        radioButtons.get(i).setText(q.Choices.get(i));
                    }
                    break;
                case TextEntry:
                    MakeViewVisible(editText);
                    break;

            }
        }

        //increase the number of questionsAsked if there are more in the list!
        //if not nullify the q object to prevent un wanted actions and show the score.
        if (questionsAsked < questions.size()) {
            questionsAsked++;
        } else {
            q = null;
            Toast.makeText(this, "Your Score Is: " + score + " Out Of " + questions.size(), Toast.LENGTH_LONG).show();
        }

    }

    /**
     * this method checks the user's answer to the displayed question, if the the answer is correct
     * the score is increased by 1.
     * The Validation Process:
     * the process of validation is the following:
     * 1. since the structure of the question object is that the answer is stored as an
     * index number pointing to string the list of choices
     */
    private void checkTheUsersAnswer() {
        switch (q.QuestionType) {
            case RadioButton:
                for (RadioButton rB : radioButtons) {
                    if (rB.isChecked()) {
                        if (isAnswerCorrect(q, rB.getText().toString())) {
                            score++;
                        }
                    }
                }
                break;
            case CheckBox:
                boolean incorrectCheckBoxChecked = false;
                ArrayList<Integer> checkedIndices = new ArrayList<>();

                for (CheckBox cB : checkBoxes) {
                    if (cB.isChecked()) {
                        if (!q.CorrectIndices.contains(checkBoxes.indexOf(cB))) {
                            incorrectCheckBoxChecked = true;
                        }
                        checkedIndices.add(checkBoxes.indexOf(cB));
                    }
                }

                if (!incorrectCheckBoxChecked && checkedIndices.containsAll(q.CorrectIndices)) {
                    score++;
                }
                break;
            case TextEntry:
                if (isAnswerCorrect(q, editText.getText().toString())) {
                    score++;
                }
                break;
        }
    }

    /**
     * because this method is used in 3 different places I decided to make it
     *
     * @param q
     */
    private void setQuestionText(Question q) {
        theQuestionTextView.setText(q.TheQuestion);
    }

    /**
     * in this method question objects are added to the questions list that will be used for
     * displaying questions.
     */
    private void InitializeTheQuestions() {
        //Radio Button questions
        questions.add(new Question("Is Java...?",
                Arrays.asList("Strongly Typed", "Loosely Typed"),
                Arrays.asList(0),
                Question.QuestionTypes.RadioButton));

        questions.add(new Question("Is Java...?",
                Arrays.asList("Platform Dependent", "Platform Independent"),
                Arrays.asList(1),
                Question.QuestionTypes.RadioButton));

        //CheckBox questions
        questions.add(new Question("Choose The Incorrect Ways Of Declaring A Variable",
                Arrays.asList("int a;", "int a b;", "int a = 1", "int a = 1 2;"),
                Arrays.asList(1, 3),
                Question.QuestionTypes.CheckBox));

        questions.add(new Question("Choose What Is Not A Keyword In Java",
                Arrays.asList("last", "extends", "first", "new"),
                Arrays.asList(0, 2),
                Question.QuestionTypes.CheckBox));

        //TextEntry Question
        questions.add(new Question("What Is the Wrapper Class For the Primitive Type int?",
                Arrays.asList("Integer"),
                Arrays.asList(0),
                Question.QuestionTypes.TextEntry));
    }

    private void hideAndResetAllModularViews() {
        MakeViewGone(radioGroup);
        MakeViewGone(checkBoxesLinearLayout);
        MakeViewGone(editText);

        for (RadioButton rB : radioButtons) {
            rB.setChecked(false);
        }

        for (CheckBox cB : checkBoxes) {
            cB.setChecked(false);
        }
    }

    private void MakeViewGone(View v) {
        v.setVisibility(View.GONE);
    }

    private void MakeViewVisible(View v) {
        v.setVisibility(View.VISIBLE);
    }

    /**
     * this method should only be used for single answer type of questions
     *
     * @param q
     * @param answer
     * @return
     */
    private boolean isAnswerCorrect(Question q, String answer) {
        for (int i : q.CorrectIndices) {
            if (answer.contains(q.Choices.get(i))) {
                return true;
            }
        }
        return false;
    }
}
