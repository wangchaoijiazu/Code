package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.util.T;

public class Index extends BaseActvity {

    private Button  button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        T.showLong("Index+onCreate");
        initView();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        T.showLong("Index+onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        T.showLong("Index+onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        T.showLong("Index+onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        T.showLong("Index+onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); T.showLong("Index+onDestroy");
    }

    private void initView(){

        button=(Button)findViewById(R.id.index_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Index.this,SecondActivity.class);
                startActivity(i);
            }
        });


    }


}
