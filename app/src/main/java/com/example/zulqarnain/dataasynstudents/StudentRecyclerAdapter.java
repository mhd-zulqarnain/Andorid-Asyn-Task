package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.width;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentviewHolder> {
    List mStudents;
    Context context;
    StudentRecyclerAdapter(Context context,List<Students> mStudents){;
        this.mStudents = mStudents;
        this.context=context;
    }

    @Override
    public StudentviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        StudentviewHolder holder = new StudentviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_layout,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentviewHolder holder, int position) {

        Students student = (Students) mStudents.get(position);
        holder.bindView(student);
    }

    @Override
    public int getItemCount() {
        return mStudents.size();

    }
}
