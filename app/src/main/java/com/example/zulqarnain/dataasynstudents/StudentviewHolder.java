package com.example.zulqarnain.dataasynstudents;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class StudentviewHolder extends RecyclerView.ViewHolder {
    TextView stName;
    TextView stEmail;
    TextView stIP;
    public StudentviewHolder(View itemView) {
        super(itemView);
        stName= (TextView) itemView.findViewById(R.id.tName);
        stEmail= (TextView) itemView.findViewById(R.id.tEmail);
        stIP= (TextView) itemView.findViewById(R.id.tIPAddress);
    }
}
