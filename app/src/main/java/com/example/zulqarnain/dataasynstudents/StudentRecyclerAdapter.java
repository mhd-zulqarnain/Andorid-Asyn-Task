package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentviewHolder> {
    List mStudents;
    StudentRecyclerAdapter(List<Students> mStudents){;
        this.mStudents = mStudents;

    }

    @Override
    public StudentviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StudentviewHolder holder = new StudentviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_layout,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentviewHolder holder, int position) {
        Students students = (Students) mStudents.get(position);
        holder.stName.setText(students.getFirst_name());
        holder.stEmail.setText(students.getEmail());
        holder.stIP.setText( "IP:"+students.getEmail());

    }

    @Override
    public int getItemCount() {
        Log.d("view", "get: "+"----------------------------------------"+mStudents.size());
        return mStudents.size();

    }
}
