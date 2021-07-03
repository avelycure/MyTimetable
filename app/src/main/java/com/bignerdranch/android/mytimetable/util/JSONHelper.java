package com.bignerdranch.android.mytimetable.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class JSONHelper {
    private final static String FILE_NAME = "app\\src\\main\\res\\Timetable\\timetable.json";
    Context context;
    JSONObject jsonObject;

    public static String getFileName() {
        return FILE_NAME;
    }

    public JSONHelper(Context context) {
        this.context = context;
        jsonObject = new JSONObject();
    }

    public boolean isNotExisting(){
        File file = new File(FILE_NAME);
        return !file.exists();
    }

    public void OutputFile(){
        FileOutputStream fos = null;
        try{
            fos = context.openFileOutput(FILE_NAME,MODE_PRIVATE);
            String text = "Hello123!";
            jsonObject.put("hello",text);
            String jsonObjectString = jsonObject.toString();
            fos.write(jsonObjectString.getBytes());
        }catch (IOException | JSONException ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }finally {
            try{
                fos.close();
            }catch (IOException ex){
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void InputFile(TextView tv1){
        FileInputStream fin = null;

        try {
            fin = context.openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = jsonObject.getString("hello");
            tv1.setText(text);
        }catch (IOException | JSONException ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }finally {
            try{
                fin.close();
            }catch (IOException ex){
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}

