package com.example.tomoko.testapplication;

import java.util.ArrayList;
import java.util.List;
import android.app.Application;

public class User extends Application {
    private String name;//ユーザ名
    private String password;//パスワード
    private String address;//アドレス
    private double value=0;//評価
    private int question=0, answer=0;//質問回数,回答回数
    private String job;//職業
    private String belong;//所属
    private ArrayList<String> group;//グループ
    private int coin=0;//残りのコイン

    private String[] groupl = {"とも", "かも", "しれ", "ない", "", "", "", "", "", ""};
    //String feature;//特徴
    //List<String> belongings; //所属

    @Override
    public void onCreate() {
        super.onCreate();
        name = "";
        password = "";
        job = "";
        belong = "";
        group = new ArrayList<>();
        //あとで消す
        group.add("padington");
        group.add("国語");


    }
    public String[] getGroupl() {
        return groupl;
    }
    public void addGroupl(String newG) {
        for(int i = 0; i < groupl.length; i++) {
            if(groupl[i].equals("")) {
                groupl[i] = newG;
                break;
            }
        }
    }
    //名前を返す
    public String getName(){
        return name;
    }

    //名前を設定
    public void setName(String name) {
        this.name = name;
    }

    //パスワードを返す
    public String getPassword(){
        return password;
    }

    //パスワードを設定
    public void setPassword(String password) {this.password = password;}

    //所属を追加する
    public void setGroup(ArrayList<String> group) {
        this.group = group;
    }

    public void addGroup(String g) {this.group.add(g);}

    //所属を返す
    public ArrayList<String> getGroup() {
        return group;
    }


    public void setAddress(String s){
        address = s;
    }

    public String getAddress(){
        return address;
    }

    public void setValue(double v){
        value = v;
    }

    public double getValue(){
        return value;
    }

    public void setQuestion(int n){
        question = n;
    }

    public int getQuestion(){
        return question;
    }

    public void setAnswer(int n){
        answer = n;
    }

    public int getAnswer(){
        return answer;
    }

    public void setJob(String s){
        job = s;
    }

    public String getJob(){
        return job;
    }

    public void setBelong(String s){
        belong = s;
    }

    public String getBelong(){
        return belong;
    }

    public void setCoin(int n){
        coin = n;
    }

    public void renewCoin(int n) {
        coin += n;
    }

    public int getCoin(){
        return coin;
    }
}
/*
* public class User {
	private String name;
	private String password;
	private String address;
	private double value=0;
	private int question=0, answer=0;
	private String job;
	private String belong;
	private String group;
	private int coin=0;

	public User(String name, String password){
		this.name = name;
		this.password = password;
	}






}*/
