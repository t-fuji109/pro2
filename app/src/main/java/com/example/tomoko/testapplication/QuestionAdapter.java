package com.example.tomoko.testapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private int layoutID;
    private String[] questionlist;
    private Bitmap[] imagelist;

    static class ViewHolder {
        TextView text;
        ImageView img;
    }

    QuestAdapter(Context context, int itemLayoutId,
                 String[] questions, int[] images) {

        inflater = LayoutInflater.from(context);
        layoutID = itemLayoutId;

        questionlist = questions;
        imagelist = new Bitmap[images.length];

        for(int i = 0; i < images.length; i++ ) {
            imagelist[i] = BitmapFactory.decodeResource(context.getResources(), images[i]);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            convertView = inflater.inflate(layoutID, null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.question_icon);
            holder.text = convertView.findViewById(R.id.question_list_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag(position);
        }

        holder.img.setImageBitmap(imagelist[position]);

        holder.text.setText(questionlist[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        return questionlist.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

}
