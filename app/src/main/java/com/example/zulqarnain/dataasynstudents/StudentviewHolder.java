package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class StudentviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView stName;
    TextView stEmail;
    TextView stIP;
    ImageView stImage;
    Students student;
    LinearLayout layout;
    Context context;
    public StudentviewHolder(View itemView) {
        super(itemView);
        stName= (TextView) itemView.findViewById(R.id.tName);
        stEmail= (TextView) itemView.findViewById(R.id.tEmail);
        stIP= (TextView) itemView.findViewById(R.id.tIPAddress);
        stImage = (ImageView) itemView.findViewById(R.id.image_view);
        layout = (LinearLayout) itemView.findViewById(R.id.single_row);
        student = new Students();
        context =itemView.getContext();
    }

    public  void bindView(Students mStudent){
        student =mStudent;
        stName.setText(student.getFirst_name());
        stEmail.setText(student.getEmail());
        stIP.setText( "IP:"+student.getIp_address());
        Picasso.with(context).load(student.getImg_url()).into(stImage);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = DetailActivity.newInstance(context,student.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
