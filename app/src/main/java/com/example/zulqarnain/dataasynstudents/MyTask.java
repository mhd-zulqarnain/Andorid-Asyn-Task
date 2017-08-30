package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 8/29/2017.
 */

public class MyTask extends AsyncTask<String, Void,ArrayList<Students>> {

    Communicator communicator;
    ArrayList<Students> studentList = new ArrayList<>();

    Context context;
    TextView textView;
    MyTask(Context context , TextView textView){
        this.context=context;
        this.textView = textView;
    }


    @Override
    protected ArrayList<Students> doInBackground(String... strings) {
        String json="";
        try{
            URL url  = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader( new InputStreamReader(url.openStream()));
            String line;
            while ((line= reader.readLine())!=null){
                json+=line;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        Students students[] = new Gson().fromJson(json,Students[].class);

        for(int i=0 ; i<students.length;i++){
            studentList.add(students[i]);
        }
        
        return studentList;
    }

    @Override
    protected void onPostExecute(ArrayList<Students> studentses) {
        communicator.getStudents(studentses);
        Log.d("size ", "onPostExecute: "+studentses.size());
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }
}
