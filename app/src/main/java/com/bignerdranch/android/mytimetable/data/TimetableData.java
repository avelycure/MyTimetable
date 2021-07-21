package com.bignerdranch.android.mytimetable.data;

import android.content.Context;

import com.bignerdranch.android.mytimetable.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimetableData {
    private Context context;
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

        lessonsCh.add(Arrays.asList(" ", " ", " ", "Элективный курс по физической культуре и спорту Каф", "(сем) Уравнения математической физики 1032л", "(лек) Уравнения математической физики 544л"));
        lessonsCh.add(Arrays.asList(" ", " ", "(лек) Математические модели механики сплошной среды 216л", "(лек) Математические модели механики сплошной среды 544л"));
        lessonsCh.add(Arrays.asList("ВК", "ВК", "ВК", "ВК"));
        lessonsCh.add(Arrays.asList(" ", " ", " ", " ", "(сем) Уравнения математической физики 527л", "(сем) Философия 527л"));
        lessonsCh.add(Arrays.asList("(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л", "(лаб) Методы вычислений Каф", "(сем) Элективный курс по физической культуре и спорту Каф"));
        lessonsCh.add(Arrays.asList("(сем) Математические модели механики сплошной среды 525л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л"));
        lessonsCh.add(Arrays.asList(""));

        lessonsZn.add(Arrays.asList(" ", " ", " ", "(сем) Элективный курс по физической культуре и спорту Каф", "(лек) Уравнения математической физики 544л", "(лек) Уравнения математической физики 544л"));
        lessonsZn.add(Arrays.asList(" ", " ", "(лек) Математические модели механики сплошной среды 216л", "(лек) Философия 544л"));
        lessonsZn.add(Arrays.asList("ВК", "ВК", "ВК", "ВК"));
        lessonsZn.add(Arrays.asList(" ", " ", " ", " ", "(сем) Уравнения математической физики 527л", "(сем) Философия 527л"));
        lessonsZn.add(Arrays.asList("(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л", "(лаб) Методы вычислений Каф", "(сем) Элективный курс по физической культуре и спорту Каф"));
        lessonsZn.add(Arrays.asList("(лек) Теория вероятностей 216л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л"));
        lessonsZn.add(Arrays.asList(""));
    }

    public ArrayList<List<String>> lessonsZn = new ArrayList<>();
    public ArrayList<List<String>> lessonsCh = new ArrayList<>();

    public ArrayList<String> days = new ArrayList<>();
    public ArrayList<String> months = new ArrayList<>();

    public String[][] lessonsBegin = {{"08", "30"}, {"10", "15"}, {"12", "00"}, {"13", "50"}, {"15", "40"}, {"17", "25"}};
    public String[][] lessonsEnd = {{"10", "05"}, {"11", "50"}, {"13", "35"}, {"15", "25"}, {"17", "15"}, {"19", "00"}};

    public int[] lessonsBeginInMinute = {
            Integer.parseInt(lessonsBegin[0][0]) * 60 + Integer.parseInt(lessonsBegin[0][1]),
            Integer.parseInt(lessonsBegin[1][0]) * 60 + Integer.parseInt(lessonsBegin[1][1]),
            Integer.parseInt(lessonsBegin[2][0]) * 60 + Integer.parseInt(lessonsBegin[2][1]),
            Integer.parseInt(lessonsBegin[3][0]) * 60 + Integer.parseInt(lessonsBegin[3][1]),
            Integer.parseInt(lessonsBegin[4][0]) * 60 + Integer.parseInt(lessonsBegin[4][1]),
            Integer.parseInt(lessonsBegin[5][0]) * 60 + Integer.parseInt(lessonsBegin[5][1])};
    public int[] lessonsEndInMinute = {
            Integer.parseInt(lessonsEnd[0][0]) * 60 + Integer.parseInt(lessonsEnd[0][1]),
            Integer.parseInt(lessonsEnd[1][0]) * 60 + Integer.parseInt(lessonsEnd[1][1]),
            Integer.parseInt(lessonsEnd[2][0]) * 60 + Integer.parseInt(lessonsEnd[2][1]),
            Integer.parseInt(lessonsEnd[3][0]) * 60 + Integer.parseInt(lessonsEnd[3][1]),
            Integer.parseInt(lessonsEnd[4][0]) * 60 + Integer.parseInt(lessonsEnd[4][1]),
            Integer.parseInt(lessonsEnd[5][0]) * 60 + Integer.parseInt(lessonsEnd[5][1])};
}
