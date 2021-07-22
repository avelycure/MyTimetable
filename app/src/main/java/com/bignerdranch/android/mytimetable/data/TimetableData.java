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

        lessonsCh.add(Arrays.asList("", "", "", "(сем) Элективный курс по физической культуре и спорту Каф", "(сем) Уравнения математической физики 1032л", "(лек) Уравнения математической физики 544л"));
        lessonsCh.add(Arrays.asList("", "", "(лек) Математические модели механики сплошной среды 216л", "(лек) Математические модели механики сплошной среды 544л", "", ""));
        lessonsCh.add(Arrays.asList("ВК", "ВК", "ВК", "ВК", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "", "(сем) Уравнения математической физики 527л", "(сем) Философия 527л"));
        lessonsCh.add(Arrays.asList("(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л", "(лаб) Методы вычислений Каф", "(сем) Элективный курс по физической культуре и спорту Каф", "", ""));
        lessonsCh.add(Arrays.asList("(сем) Математические модели механики сплошной среды 525л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "", "", ""));

        lessonsZn.add(Arrays.asList("", "", "", "(сем) Элективный курс по физической культуре и спорту Каф", "(лек) Уравнения математической физики 544л", "(лек) Уравнения математической физики 544л"));
        lessonsZn.add(Arrays.asList("", "", "(лек) Математические модели механики сплошной среды 216л", "(лек) Философия 544л", "", ""));
        lessonsZn.add(Arrays.asList("ВК", "ВК", "ВК", "ВК", "", ""));
        lessonsZn.add(Arrays.asList("", "", "", "", "(сем) Уравнения математической физики 527л", "(сем) Философия 527л"));
        lessonsZn.add(Arrays.asList("(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л", "(лаб) Методы вычислений Каф", "(сем) Элективный курс по физической культуре и спорту Каф", "", ""));
        lessonsZn.add(Arrays.asList("(лек) Теория вероятностей 216л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л", "", ""));
        lessonsZn.add(Arrays.asList("", "", "", "", "", ""));

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

    public ArrayList<List<String>> lessonsZn = new ArrayList<>();
    public ArrayList<List<String>> lessonsCh = new ArrayList<>();
    public ArrayList<String> days = new ArrayList<>();
    public ArrayList<String> months = new ArrayList<>();
    public ArrayList<List<String>> lessonsBegin = new ArrayList<>();
    public ArrayList<List<String>> lessonsEnd = new ArrayList<>();
    public ArrayList<Integer> lessonsBeginInMinute = new ArrayList<>();
    public ArrayList<Integer> lessonsEndInMinute = new ArrayList<>();
}
