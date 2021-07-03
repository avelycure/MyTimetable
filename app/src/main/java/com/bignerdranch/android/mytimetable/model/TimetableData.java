package com.bignerdranch.android.mytimetable.model;

public class TimetableData {
    private int date;

    public static String[] days = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};

    public static String[] months = {"января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря"};

    public static String[][] lessonsZn = {
            {" "," ", " ","(сем) Элективный курс по физической культуре и спорту Каф","(лек) Уравнения математической физики 544л","(лек) Уравнения математической физики 544л"},
            {" "," ","(лек) Математические модели механики сплошной среды 216л", "(лек) Философия 544л"},
            {"ВК","ВК","ВК","ВК"},
            {" "," ", " "," ","(сем) Уравнения математической физики 527л","(сем) Философия 527л"},
            {"(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л","(лаб) Методы вычислений Каф","(сем) Элективный курс по физической культуре и спорту Каф"},
            {"(лек) Теория вероятностей 216л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л"},
            {}};

    public static String[][] lessonsCh = {
            {" "," "," ","Элективный курс по физической культуре и спорту Каф","(сем) Уравнения математической физики 1032л", "(лек) Уравнения математической физики 544л"},
            {" "," ","(лек) Математические модели механики сплошной среды 216л", "(лек) Математические модели механики сплошной среды 544л"},
            {"ВК","ВК","ВК","ВК"},
            {" "," ", " "," ","(сем) Уравнения математической физики 527л","(сем) Философия 527л"},
            {"(сем) Методы вычислений 525л", "(лек) Методы вычислений 544л","(лаб) Методы вычислений Каф","(сем) Элективный курс по физической культуре и спорту Каф"},
            {"(сем) Математические модели механики сплошной среды 525л", "(лек) Теория вероятностей 212л", "(сем) Математические модели механики сплошной среды 527л", "(сем) Теория вероятностей 527л"},
            {}};

    public static String[][] lessonsBegin = {{"08","30"},{"10","15"},{"12","00"},{"13","50"},{"15","40"},{"17","25"}};
    public static String[][] lessonsEnd = {{"10","05"},{"11","50"},{"13","35"},{"15","25"},{"17","15"},{"19","00"}};

    public static int[] lessonsBeginInMinute = {
            Integer.parseInt(lessonsBegin[0][0]) * 60 + Integer.parseInt(lessonsBegin[0][1]),
            Integer.parseInt(lessonsBegin[1][0]) * 60 + Integer.parseInt(lessonsBegin[1][1]),
            Integer.parseInt(lessonsBegin[2][0]) * 60 + Integer.parseInt(lessonsBegin[2][1]),
            Integer.parseInt(lessonsBegin[3][0]) * 60 + Integer.parseInt(lessonsBegin[3][1]),
            Integer.parseInt(lessonsBegin[4][0]) * 60 + Integer.parseInt(lessonsBegin[4][1]),
            Integer.parseInt(lessonsBegin[5][0]) * 60 + Integer.parseInt(lessonsBegin[5][1])};
    public static int[] lessonsEndInMinute = {
            Integer.parseInt(lessonsEnd[0][0]) * 60 + Integer.parseInt(lessonsEnd[0][1]),
            Integer.parseInt(lessonsEnd[1][0]) * 60 + Integer.parseInt(lessonsEnd[1][1]),
            Integer.parseInt(lessonsEnd[2][0]) * 60 + Integer.parseInt(lessonsEnd[2][1]),
            Integer.parseInt(lessonsEnd[3][0]) * 60 + Integer.parseInt(lessonsEnd[3][1]),
            Integer.parseInt(lessonsEnd[4][0]) * 60 + Integer.parseInt(lessonsEnd[4][1]),
            Integer.parseInt(lessonsEnd[5][0]) * 60 + Integer.parseInt(lessonsEnd[5][1])};
    private TimetableData(String day, int date){
        this.date = date;
    }
}
