package com.example.admin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author 王超
 * @title listviewadapter
 * @description
 * @modifier
 * @date
 * @since 2015/11/9 16:33
 **/
public class listviewadapter extends BaseAdapter {

    private Context context;
    public listviewadapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v= LayoutInflater.from(context).inflate(R.layout.item,null);
        return v;
    }
}
