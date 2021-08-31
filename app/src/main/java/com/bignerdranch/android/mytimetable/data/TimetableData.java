package com.bignerdranch.android.mytimetable.data;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimetableData {
    private static final int DAYS_IN_WEEK = 7;
    private static final int LESSONS_A_DAY = 6;
    public ArrayList<ArrayList<String>> lessonsZn;
    public ArrayList<ArrayList<String>> lessonsCh;
    public ArrayList<String> days;
    public ArrayList<String> months;
    public ArrayList<List<String>> lessonsBegin;
    public ArrayList<List<String>> lessonsEnd;
    public ArrayList<Integer> lessonsBeginInMinute;
    public ArrayList<Integer> lessonsEndInMinute;

    public TimetableData() {
        lessonsZn = new ArrayList<>();
        lessonsCh = new ArrayList<>();
        days = new ArrayList<>();
        months = new ArrayList<>();
        lessonsBegin = new ArrayList<>();
        lessonsEnd = new ArrayList<>();
        lessonsBeginInMinute = new ArrayList<>();
        lessonsEndInMinute = new ArrayList<>();

        months.add("января");months.add("февраля");
        months.add("марта");months.add("апреля");months.add("мая");
        months.add("июня");months.add("июля");months.add("августа");
        months.add("сентября");months.add("октября");months.add("ноября");
        months.add("декабря");

        days.add("Понедельник");
        days.add("Вторник");
        days.add("Среда");
        days.add("Четверг");
        days.add("Пятница");
        days.add("Суббота");
        days.add("Воскресенье");

        lessonsBegin.add(Arrays.asList("08", "30")); lessonsEnd.add(Arrays.asList("10", "05"));
        lessonsBegin.add(Arrays.asList("10", "15")); lessonsEnd.add(Arrays.asList("11", "50"));
        lessonsBegin.add(Arrays.asList("12", "00")); lessonsEnd.add(Arrays.asList("13", "35"));
        lessonsBegin.add(Arrays.asList("13", "50")); lessonsEnd.add(Arrays.asList("15", "25"));
        lessonsBegin.add(Arrays.asList("15", "40")); lessonsEnd.add(Arrays.asList("17", "15"));
        lessonsBegin.add(Arrays.asList("17", "25")); lessonsEnd.add(Arrays.asList("19", "00"));

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

    public void writeToFile(ArrayList<ArrayList<String>> list, String fileName, Context context) throws IOException, JSONException {
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

    public void writeEmptyFile(String fileName, Context context) throws JSONException, IOException {
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

    public String getResponse(String fileName, Context context) throws IOException, JSONException {
        File file = new File(context.getFilesDir(), fileName);
        if (!file.exists())
            writeEmptyFile(fileName, context);

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

    public void readFile(ArrayList<ArrayList<String>> lessons, String response) throws JSONException {
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
        String response = getResponse(fileNameCh, context);
        readFile(lessonsCh, response);

        response = getResponse(fileNameZn, context);
        readFile(lessonsZn, response);
    }

}
