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

        lessonsCh.add(Arrays.asList("(лек) Дополнительные главы механики сплошной среды 544л Кувыркин Г.Н.",
                "(сем) Безопасность жизнедеятельности 525л Вазаева Н.В.", "(сем) Математические модели прикладной механики 1011л Савельева И.Ю.", "", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "(сем) Дополнительные главы механики сплошной среды 1011л Савельева И.Ю.",
                "(лек) Безопасность жизнедеятельности 1108л Морозов С.Д.", "(лек) Экономика часть 1 544л Сажин Ю.Б."));
        lessonsCh.add(Arrays.asList("(лек) Основы математического моделирования 212л Галанин М.П.",
                "(сем) Основы математического моделирования 1017л Деревич И.В.", "", "", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "", "(лек) Разработка программных комплексов 255л Темис Ю.М.",
                "(сем) Разработка программных комплексов 1011л Лазарев А.А."));
        lessonsCh.add(Arrays.asList("(лек) Математические модели прикладной механики 1011л Зарубин В.С.",
                "(сем) Технологии параллельных вычислений Каф", "(сем) Технологии параллельных вычислений Каф", "", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "", "", ""));
        lessonsCh.add(Arrays.asList("", "", "", "", "", ""));


        lessonsZn.add(Arrays.asList("(лек) Дополнительные главы механики сплошной среды 544л Кувыркин Г.Н.",
                "Экономика часть 1 525л Косолап Е.Ю.", "(сем) Математические модели прикладной механики 1011л Савельева И.Ю.", "", "", ""));
        lessonsZn.add(Arrays.asList("", "", "(сем) Дополнительные главы механики сплошной среды 1011л Савельева И.Ю.",
                "(сем) Дополнительные главы механики сплошной среды 1011л Савельева И.Ю.",
                "(лек) Безопасность жизнедеятельности 1108л Морозов С.Д.", ""));
        lessonsZn.add(Arrays.asList("(лек) Основы математического моделирования 212л Галанин М.П.",
                "(сем) Основы математического моделирования 1017л Деревич И.В.", "", "", "", ""));
        lessonsZn.add(Arrays.asList("", "", "", "(лаб) Разработка программных комплексов Каф",
                "(лек) Разработка программных комплексов 255л Темис Ю.М.",
                "(сем) Разработка программных комплексов 1011л Лазарев А.А."));
        lessonsZn.add(Arrays.asList("(лек) Математические модели прикладной механики 1011л Зарубин В.С.",
                "(сем) Технологии параллельных вычислений Каф", "(сем) Технологии параллельных вычислений Каф", "", "", ""));
        lessonsZn.add(Arrays.asList("", "", "", "", "", ""));
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
