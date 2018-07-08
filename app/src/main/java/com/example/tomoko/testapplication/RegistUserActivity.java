package com.example.tomoko.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistUserActivity extends AppCompatActivity {

    private TextView userNameView;
    private EditText feature;
    private Button registButton;
    private ImageButton searchButton;
    private ListView groupListView;
    private EditText searchGroupText;


    private String userName;
    private String spinnerItems[] = {"高校生", "大学生", "大学院生", "会社員", "そのほか"};//内容未定
    private String item;
    private String form_group_textView;

    private ArrayList<String> grouplist;

    User user;
    Client client;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_user);

        client = (Client)this.getApplication();
        activity = this;
        user = client.getMyUser();

        grouplist = new ArrayList<>();

        userName = user.getName();
        userNameView = findViewById(R.id.userNameView2);
        userNameView.setText(userName);
        feature = (EditText)findViewById(R.id.feature_text);
        Spinner spinner = findViewById(R.id.professionspinner);
        searchButton = findViewById(R.id.search_button);
        groupListView = (ListView)findViewById(R.id.group);
        searchGroupText = findViewById(R.id.group_search_name);
        int n = 0;

        switch (user.getJob()) {
            case "高校生":
                n = 0;
                break;
            case "大学生":
                n = 1;
                break;
            case "大学院生":
                n = 2;
                break;
            case "会社員":
                n = 3;
                break;
            case "そのほか":
                n = 4;
                break;
            default:
                n = 0;
                break;
        }

        userNameView.setText(userName);
        feature.setText(user.getBelong());
        spinner.setSelection(n);

        /*grouplist = user.getGroup();

        ArrayList<String> items = new ArrayList<>();

        for(int i = 0; i < grouplist.size(); i++) {
            items.add(grouplist.get(i));
        }*/

        ArrayAdapter<String> groupAdapter = new ArrayAdapter<>(
                this,
                R.layout.group_text,
                user.getGroupl()
        );

        groupListView.setAdapter(groupAdapter);
        //group.setOnItemClickListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner = (Spinner)adapterView;
                item = (String)spinner.getSelectedItem();
                user.setBelong(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        registButton = findViewById(R.id.registSetting);
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String job = item;
                String belong = feature.getText().toString();
                //ユーザ情報を登録する
                client.sendUserInformation(job, belong, grouplist, activity);
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                user.setBelong(feature.getText().toString());
                //user.setGroup(grouplist);
                startActivity(intent);

            }

        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String s = searchGroupText.getText().toString();
                //client.setListener(createListener());
                client.setOnCallBack(new Client.CallBackTask() {
                    public void CallBack(String result) {
                        super.CallBack(result);
                        if(result.equals("検索失敗")) {
                            toastMake(result, 0, -200);
                            //client.receiveUserInformation(userName, activity);
                            //Intent intent = new Intent(getApplication(), RegistUserActivity.class);
                            //startActivity(intent);
                        } else if(result.equals("グループなし")) {
                            toastMake("グループは存在しません", 0, -200);
                        } else {
                            toastMake("グループが見つかりました", 0, -200);
                            //user.addGroup(s);
                            /*ArrayAdapter<String> groupAdapter = new ArrayAdapter<String>(
                                    activity,
                                    R.layout.group_text,
                                    user.getGroup()
                            );*/

                            //group.setAdapter(groupAdapter);
                        }
                    }
                });
                client.requestGroupSearch(s, activity);
                //Intent intent = new Intent(getApplication(), GroupSearchActivity.class);
                //intent.putExtra("Keyword", searchGroupText.getText().toString());
                user.setBelong(feature.getText().toString());
                //startActivity(intent);
            }
        });


    }
    void toastMake(String message, int x, int y) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);

        toast.setGravity(Gravity.CENTER, x,y);
        toast.show();
    }

}
