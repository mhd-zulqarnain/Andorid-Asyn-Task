package com.example.zulqarnain.dataasynstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator {

    ArrayList<Students> list;
    TextView textView;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
        myButton = (Button) findViewById(R.id.button_response);
        list = new ArrayList<>();
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask(MainActivity.this, textView);
                task.setCommunicator(MainActivity.this);
                task.execute("https://api.myjson.com/bins/1fqq85");



                Log.d("size", "onClick: " + list.size());
            }
        });
    }


    @Override
    public void getStudents(ArrayList<Students> studentses) {
        this.list = studentses;
        String name = "";
        for (int i = 0; i < list.size(); i++) {
            name += " " + list.get(i).first_name;
        }
        textView.setText(name);
        Log.d("size", "getStudents: called"+list.size());

    }
}
