package com.bignerdranch.android.mytimetable.data;

import android.content.Context;
import android.util.Log;

import com.bignerdranch.android.mytimetable.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

public class TimetableData {
    private Context context;
    private static final int DAYS_IN_WEEK = 7;
    private static final int LESSONS_A_DAY = 6;
    public ArrayList<List<String>> lessonsZn = new ArrayList<>();
    public ArrayList<List<String>> lessonsCh = new ArrayList<>();
    public ArrayList<String> days = new ArrayList<>();
    public ArrayList<String> months = new ArrayList<>();
    public ArrayList<List<String>> lessonsBegin = new ArrayList<>();
    public ArrayList<List<String>> lessonsEnd = new ArrayList<>();
    public ArrayList<Integer> lessonsBeginInMinute = new ArrayList<>();
    public ArrayList<Integer> lessonsEndInMinute = new ArrayList<>();

    public TimetableData(Context context) {
        this.context = context;

        months.add(context.getResources().getString(R.string.january));
        months.add(context.getResources().getString(R.string.february));
        months.add(context.getResources().getString(R.string.march));
        months.add(context.getResources().getString(R.string.april));
        months.add(context.getResources().getString(R.string.may));
        months.add(context.getResources().getString(R.string.june));
        months.add(context.getResources().getString(R.string.july));
        months.add(context.getResources().getString(R.string.august));
        months.add(context.getResources().getString(R.string.september));
        months.add(context.getResources().getString(R.string.october));
        months.add(context.getResources().getString(R.string.november));
        months.add(context.getResources().getString(R.string.december));

        days.add(context.getResources().getString(R.string.monday));
        days.add(context.getResources().getString(R.string.tuesday));
        days.add(context.getResources().getString(R.string.wednesday));
        days.add(context.getResources().getString(R.string.thursday));
        days.add(context.getResources().getString(R.string.friday));
        days.add(context.getResources().getString(R.string.saturday));
        days.add(context.getResources().getString(R.string.sunday));

        lessonsBegin.add(Arrays.asList("08", "30"));
        lessonsBegin.add(Arrays.asList("10", "15"));
        lessonsBegin.add(Arrays.asList("12", "00"));
        lessonsBegin.add(Arrays.asList("13", "50"));
        lessonsBegin.add(Arrays.asList("15", "40"));
        lessonsBegin.add(Arrays.asList("17", "25"));

        lessonsEnd.add(Arrays.asList("10", "05"));
        lessonsEnd.add(Arrays.asList("11", "50"));
        lessonsEnd.add(Arrays.asList("13", "35"));
        lessonsEnd.add(Arrays.asList("15", "25"));
        lessonsEnd.add(Arrays.asList("17", "15"));
        lessonsEnd.add(Arrays.asList("19", "00"));

        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(0).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(0).get(1)));
        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(1).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(1).get(1)));
        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(2).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(2).get(1)));
        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(3).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(3).get(1)));
        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(4).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(4).get(1)));
        lessonsBeginInMinute.add(Integer.parseInt(lessonsBegin.get(5).get(0)) * 60 + Integer.parseInt(lessonsBegin.get(5).get(1)));

        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(0).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(0).get(1)));
        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(1).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(1).get(1)));
        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(2).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(2).get(1)));
        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(3).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(3).get(1)));
        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(4).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(4).get(1)));
        lessonsEndInMinute.add(Integer.parseInt(lessonsEnd.get(5).get(0)) * 60 + Integer.parseInt(lessonsEnd.get(5).get(1)));
    }

    public void writeToFile(ArrayList<List<String>> list, String fileName, Context context) throws IOException, JSONException {
        JSONObject week = new JSONObject();
        JSONArray day;
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            day = new JSONArray();
            for (int j = 0; j < LESSONS_A_DAY; j++) {
                day.put(list.get(i).get(j));
            }
            week.put(Integer.toString(i), day);
        }

        String weekString = week.toString();

        File file = new File(context.getFilesDir(), fileName);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(weekString);
        bufferedWriter.close();
    }

    public void writeEmptyFile(String fileName) throws JSONException, IOException {
        JSONObject week = new JSONObject();
        JSONArray day;
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            day = new JSONArray();
            for (int j = 0; j < LESSONS_A_DAY; j++)
                day.put("");
            week.put(Integer.toString(i), day);
        }

        String weekString = week.toString();

        File file = new File(context.getFilesDir(), fileName);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(weekString);
        bufferedWriter.close();
    }

    public String getResponse(String fileName) throws IOException, JSONException {
        File file = new File(context.getFilesDir(), fileName);
        if (!file.exists())
            writeEmptyFile(fileName);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public void readFile(ArrayList<List<String>> lessons, String response) throws JSONException {
        JSONArray jsonArray;
        ArrayList<String> list;
        JSONObject jsonResponse = new JSONObject(response);
        lessons.clear();
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            list = new ArrayList<>();
            jsonArray = jsonResponse.getJSONArray(Integer.toString(i));
            for (int j = 0; j < LESSONS_A_DAY; j++)
                list.add((String) jsonArray.get(j));
            lessons.add(list);
        }
    }

    public void readFromFile(String fileNameCh, String fileNameZn, Context context) throws IOException, JSONException {
        String response = getResponse(fileNameCh);
        readFile(lessonsCh, response);

        response = getResponse(fileNameZn);
        readFile(lessonsZn, response);
    }

}
