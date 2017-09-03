package com.example.zulqarnain.dataasynstudents;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Zul Qarnain on 9/1/2017.
 */

public class StudentRecord /*implements Communicator*/ {

    ArrayList<Students> studentRecord;
    /*private  static StudentRecord mRecord;
    public static StudentRecord getStudentRecord(){
        if (mRecord == null){
            mRecord =new StudentRecord();
        }
        return mRecord;
    }*/
    String json;
    Context context;
   public  StudentRecord(Context c){
        studentRecord = new ArrayList<>();
//        updateRecord();
       this.context = c;
    }
  /* private void updateRecord(){
       MyTask task = new MyTask();
       task.setCommunicator(this);
       try {
           task.execute("https://api.myjson.com/bins/upwut").get();
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }


   }
*/
    public void getStudents(String students) {

        this.json=students;
    }

    public ArrayList<Students> getRecord(){
        updateList();
        return studentRecord;
    }

    private void updateList(){
         Students students[] = new Gson().fromJson(json,Students[].class);
        for(int i=0 ; i<students.length;i++){
            studentRecord.add(students[i]);
        }
    }

    public String getJson(){
        return json;
    }
}
