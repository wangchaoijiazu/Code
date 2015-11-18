package com.example.admin.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.util.T;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }

                });
        T.showLong("B+onCreate");

    }



    @Override
    protected void onStart() {
        super.onStart();
        T.showLong("B+onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        T.showLong("B+onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        T.showLong("B+onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        T.showLong("B+onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        T.showLong("B+onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        T.showLong("B+onDestroy");
    }
}
