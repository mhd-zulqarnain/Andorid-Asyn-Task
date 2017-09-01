package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class DetailActivity extends AppCompatActivity implements Communicator {
    private static final String STUDENT_ID = "asyn_student_id";
    TextView stName;
    TextView stEmail;
    TextView stIP;
    TextView stID;
    ImageView stImage;
    TextView stGender;

    int studentID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        studentID = getIntent().getIntExtra(STUDENT_ID, 0);

        MyTask task = new MyTask(this);
        task.setCommunicator(this);
        task.execute("https://api.myjson.com/bins/upwut");
//        stName.setText();

        stName = (TextView) findViewById(R.id.tName);
        stEmail = (TextView) findViewById(R.id.tEmail);
        stIP = (TextView) findViewById(R.id.tIPAddress);
        stID = (TextView) findViewById(R.id.st_id);
        stGender = (TextView) findViewById(R.id.tGender);
        stImage = (ImageView) findViewById(R.id.image_view);

    }

    public static Intent newInstance(Context context, int studentID) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(STUDENT_ID, studentID);
        return intent;
    }

    @Override
    public void getStudents(ArrayList<Students> list) {
//        list = studentses;
        Students students=null;
        for(int i = 0; i<list.size();i++){
            if(list.get(i).getId()==studentID){
                students = list.get(i);
                break;
            }
        }
        stName.setText(students.getFirst_name() + " " + students.getFirst_name());
        stEmail.setText(students.getEmail());
        stIP.setText(students.getIp_address());
        stID.setText("Details :" + students.getId());
        stGender.setText(students.getGender());
        Picasso.with(DetailActivity.this).load(students.getImg_url()).into(stImage);

    }
}
