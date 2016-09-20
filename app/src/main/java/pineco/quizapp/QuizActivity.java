package pineco.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    MyersBriggsQuiz mb;
    QuizQuestion currQuestion;
    TextView question;
    Button b1;
    Button b2;
    int i = 0;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //quiz setup
        mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        mb = new MyersBriggsQuiz();
        if(savedInstanceState!=null)
            i = savedInstanceState.getInt("progress");
        else
            i=0;
                mProgress.setProgress((int) ((i + 1) / 0.7));
                currQuestion = mb.getQuestions().get(i);
                question = (TextView) findViewById(R.id.quiz_question);
                question.setText(currQuestion.getText());
                b1 = (Button) findViewById(R.id.b1);
                b1.setText(currQuestion.getAnswers()[0].getText());
                b2 = (Button) findViewById(R.id.b2);
                b2.setText(currQuestion.getAnswers()[1].getText());
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mb.recordResponse(currQuestion, currQuestion.getAnswers()[0]);
                        i++;
                        if (i == mb.getQuestions().size()) {
                            System.out.println(i);
                            question.setText(mb.getResult());
                            endQuiz();
                } else {
                    mProgress.setProgress((int) ((i + 1) / 0.7));
                    currQuestion = mb.getQuestions().get(i);
                    question.setText(currQuestion.getText());
                    b1.setText(currQuestion.getAnswers()[0].getText());
                    b2.setText(currQuestion.getAnswers()[1].getText());
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mb.recordResponse(currQuestion, currQuestion.getAnswers()[1]);
                i++;
                if (i == mb.getQuestions().size())
                    endQuiz();
                else {
                    mProgress.setProgress((int) ((i + 1) / 0.7));
                    currQuestion = mb.getQuestions().get(i);
                    question.setText(currQuestion.getText());
                    b1.setText(currQuestion.getAnswers()[0].getText());
                    b2.setText(currQuestion.getAnswers()[1].getText());
                }
            }
        });
    }

    public void endQuiz() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHome = new Intent(v.getContext(), MainView.class);
                v.getContext().startActivity(returnHome);
            }
        });
        b1.setText("Return to Quiz List");
        b2.setVisibility(View.INVISIBLE);
        String r = mb.getResult();
        question.setText(r);
        QuizTransfer.setMBResults(r);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("progress", i);
        savedInstanceState.putIntArray("results", mb.getResultsArray());
        super.onSaveInstanceState(savedInstanceState);
    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        i = savedInstanceState.getInt("progress");
        int[] savedResultsArray = savedInstanceState.getIntArray("results");
        mb.setResultsArray(savedResultsArray);
    }
}
