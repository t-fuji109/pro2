package com.example.tomoko.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class CheckWhoWannaAnsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] qDataset = {
            "質問があります,0", "悩んでいます,1","どうやって解けばよいですか,0"
    };

    String[] number = {
            "5", "2", "3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_who_wanna_ans);

        ListView anslistView = (ListView)findViewById(R.id.question_room_list_view);

        //BaseAdapterを継承したadapterのインスタンスを生成
        BaseAdapter adapter = new WantAnsAdapter(this.getApplicationContext(), R.layout.who_wanna_ask_text_view,
                qDataset, number);

        anslistView.setAdapter(adapter);
        anslistView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            //Intent intent = new Intent(this.getApplicationContext(), CheckQuestionActivity.class);
            //String selectedText = questions[position];
            //intent.putExtra("Text", selectedText);
            //startActivity(intent);

    }
}
