package com.example.zulqarnain.dataasynstudents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 8/30/2017.
 */

public class DetailFragment extends Fragment implements Communicator {
    private static final String STUDENT_ID = "asyn_student_id";
    TextView stName;
    TextView stEmail;
    TextView stIP;
    TextView stID;
    ImageView stImage;
    TextView stGender;
    int studentID;


    public static Fragment newInstance(int studentID) {
        Bundle args = new Bundle();
        args.putInt(STUDENT_ID, studentID);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);
        studentID = getArguments().getInt(STUDENT_ID);

        MyTask task = new MyTask(container.getContext());
        task.setCommunicator(this);
        task.execute("https://api.myjson.com/bins/a3jmh");
        stName = (TextView) view.findViewById(R.id.tName);
        stEmail = (TextView) view.findViewById(R.id.tEmail);
        stIP = (TextView) view.findViewById(R.id.tIPAddress);
//        stID = (TextView) view.findViewById(R.id.st_id);
        stGender = (TextView) view.findViewById(R.id.tGender);
        stImage = (ImageView) view.findViewById(R.id.image_view);

        return view;
    }


    @Override
    public void getStudents(ArrayList<Students> list) {
        Students students = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == studentID) {
                students = list.get(i);
                break;
            }
        }
        stName.setText(students.getFirst_name() + " " + students.getFirst_name());
        stEmail.setText(students.getEmail());
        stIP.setText(students.getIp_address());
//        stID.setText("Details :" + students.getId());
        stGender.setText(students.getGender());
        Picasso.with(getActivity()).load(students.getImg_url()).into(stImage);

    }
}
