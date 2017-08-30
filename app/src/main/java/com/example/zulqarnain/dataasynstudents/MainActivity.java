package com.example.zulqarnain.dataasynstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator {

    ArrayList<Students> list;
    Button myButton;
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.button_response);
        mRecycler = (RecyclerView) findViewById(R.id.my_Recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask(MainActivity.this);
                task.setCommunicator(MainActivity.this);
                task.execute("https://api.myjson.com/bins/1fqq85");

            }
        });
    }


    @Override
    public void getStudents(ArrayList<Students> studentses) {
        this.list = studentses;
        updateUI();

    }

    public void updateUI() {
        Log.d("view", "sending: "+"----------------------------------------"+list.size());

        StudentRecyclerAdapter adapter= new StudentRecyclerAdapter(list);
        mRecycler.setAdapter(adapter);
    }
}
