package com.example.tomoko.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TalkManageActivity extends AppCompatActivity {
    ImageButton homeButton;
    ImageButton noticeButton;
    ImageButton moneyButton;
    ImageButton groupButton;

    Button answerAppButton;
    Button answerCheckButton;
    Button offerCheckButton;

    User user;
    Client client;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_manage);

        client = (Client)this.getApplication();
        activity = this;
        user = client.getMyUser();

        homeButton = findViewById(R.id.home_button);
        noticeButton = findViewById(R.id.notice_button);
        moneyButton = findViewById(R.id.money_button);
        groupButton = findViewById(R.id.group_button);

        answerAppButton = findViewById(R.id.answer_app_button);
        answerCheckButton = findViewById(R.id.answer_check_button);
        offerCheckButton = findViewById(R.id.offer_check_button);

        //ホームボタンが押されたらホーム画面へ
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });
        //グループボタンが押されたらグループ画面へ
        groupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), GroupActivity.class);
                startActivity(intent);
            }
        });

        //お知らせボタンが押されたらお知らせ画面へ
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), NoticeActivity.class);
                startActivity(intent);
            }
        });

        //お金管理が押されたら、お金管理画面へ
        moneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MoneyActivity.class);
                startActivity(intent);
            }
        });

        answerAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), AnswerAppActivity.class);
                startActivity(intent);
            }
        });

        answerCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), AnswerListActivity.class);
                startActivity(intent);
            }
        });

        offerCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), OfferCheckActivity.class);
                startActivity(intent);
            }
        });
    }
}
