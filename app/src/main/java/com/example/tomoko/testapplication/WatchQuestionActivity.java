package com.example.tomoko.testapplication2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class WatchQuestionActivity extends AppCompatActivity {

    String question;
    String answer;
    TextView questionTextView;
    TextView answerTextView;
    RatingBar ratingBar;
    Button alertButton;
    Button sendEqButton;

    private DialogFragment dialogFragment;
    private FragmentManager flagmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_question);

        Intent intent = getIntent();

        questionTextView = findViewById(R.id.question_text);
        answerTextView = findViewById(R.id.answer_text);
        ratingBar = findViewById(R.id.rating_bar_wq);
        alertButton = findViewById(R.id.alert_button);
        sendEqButton = findViewById(R.id.send_equivalent_button);

        question = intent.getStringExtra("Text");
        answer = "ここを参考にしてみては。https://akira-watson.com";

        questionTextView.setText(question);
        answerTextView.setText(answer);

        sendEqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //評価値を取得
                int rate = ratingBar.getNumStars();
            }
        });

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flagmentManager = getSupportFragmentManager();

                dialogFragment = new WatchQuestionActivity.AlertDialogFragment();
                dialogFragment.show(flagmentManager, "send alert dialogue");
            }
        });
    }
    //送金時の確認ダイアログ
    public static class AlertDialogFragment extends DialogFragment {
        //選択肢のリスト
        private String[] menulist = {"通報する", "通報しない"};

        @Override
        @NonNull
        public Dialog onCreateDialog(Bundle saveInstanceState) {
            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            //タイトル
            alert.setTitle("通報しますか?");
            alert.setItems(menulist, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //通報する
                    if (i == 0) {

                    }
                    //通報しない
                    else {
                        //
                    }
                }
            });
            return alert.create();
        }

    }
}
