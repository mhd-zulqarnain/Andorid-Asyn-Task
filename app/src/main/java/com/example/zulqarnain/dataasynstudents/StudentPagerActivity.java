package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Zul Qarnain on 9/1/2017.
 */

public class StudentPagerActivity extends AppCompatActivity implements Communicator {

    ViewPager studentPager;
    ArrayList<Students> list;
    private static final String STUDENT_ID = "studentId";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_activity_layout);
        list = new ArrayList<>();
        try {
            startAsynTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentPager = (ViewPager) findViewById(R.id.student_pager);
        Log.d("TAG", "On Created in studentPagerActivity " + list.size());


    }

    public static Intent newInstance(Context context, int studentID) {
        Intent intent = new Intent(context, StudentPagerActivity.class);
        intent.putExtra(STUDENT_ID, studentID);
        return intent;
    }

    public void startAsynTask() throws ExecutionException, InterruptedException {
        MyTask task = new MyTask(StudentPagerActivity.this);
        task.setCommunicator(StudentPagerActivity.this);
        task.execute("https://api.myjson.com/bins/a3jmh").get();
    }

    @Override
    public void getStudents(ArrayList<Students> studentses) {
        this.list = studentses;
        updateUI();

    }

    public void updateUI() {
        studentPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return DetailFragment.newInstance(list.get(position).getId());
            }

            @Override
            public int getCount() {
                return list.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position).getFirst_name();
            }

        });
    }


}
