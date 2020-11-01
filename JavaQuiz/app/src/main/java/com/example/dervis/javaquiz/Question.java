package com.example.dervis.javaquiz;

import java.util.List;

/**
 * this object is structured in such a way to help store all kinds of questions:
 * 1. single answer with no choices.
 * 2. single answer with choices.
 * 3. multiple answers with choices.
 * <p>
 * -------------------------------------------------------------------------------------------------
 * <p>
 * the way the questions are stored is the following:
 * 1. the text of the question is stored in TheQuestion.
 * 2. the choices list stores the correct answer if the question type is textEntry, two answers if
 *    the question type is radioButton, four answers if the question type is checkBox, no less no
 *    more!!!.
 * 3. the indices of correct answers that are in the choices list are stored in the correctIndices
 *    list
 */
public class Question {

    String TheQuestion;
    List<String> Choices;
    List<Integer> CorrectIndices;
    QuestionTypes QuestionType;

    public Question(String theQuestion, List<String> choices, List<Integer> correctIndices, QuestionTypes questionType) {
        TheQuestion = theQuestion;
        Choices = choices;
        CorrectIndices = correctIndices;
        QuestionType = questionType;
    }

    /**
     * these enums help determine the way to translate the question to UI views because each type of
     * question has a different way of displaying it
     */
    enum QuestionTypes {
        RadioButton, CheckBox, TextEntry
    }

}
