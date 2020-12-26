package com.bignerdranch.android.mytimetable;

public class Timetable {
    private int date;
    public static String[] days = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
    public static String[] months = {"января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря"};
    public static String[][] lessonsZn = {
            {" ","(лек) Теория управления 216л","(сем) Физика 524л","(сем) Теория управления 525л","Французский язык Каф"},
            {"(лек) Физика 216л","(лек) Методы оптимизации и вариационное исчисление 216л"," ","(лаб) Методы вычислений Каф"},
            {"ВК","ВК","ВК","ВК"},
            {" "," ", "(сем) Элективный курс по физической культуре и спорту Каф","(сем) Русский язык и культура речи 525л",
            "(лек) Теория вероятностей 216л","(сем) Теория вероятностей 1030л"},
            {"(сем) Методы вычислений 527л", "(лек) Методы вычислений 216л","(сем) Методы оптимизации и вариационное исчисление 1032л",
            "Элективный курс по физической культуре и спорту Каф"},
            {"(лаб) Физика Каф", "(лаб) Физика Каф"},
            {}};

    public static String[][] lessonsCh = {
            {"(лек) Русский язык и культура речи 1108л","(лек) Теория управления 216л","(лаб) Методы оптимизации и вариационное исчисление Каф",
            "(сем) Теория управления 525л","Французский язык Каф"},
            {"(лек) Физика 216л","(лек) Методы оптимизации и вариационное исчисление 216л"," ","(лаб) Методы вычислений Каф"},
            {"ВК","ВК","ВК","ВК"},
            {" "," ","(сем) Элективный курс по физической культуре и спорту Каф"," ","(лек) Теория вероятностей 216л","(сем) Теория вероятностей 1030л"},
            {"(сем) Методы вычислений 527л", "(лек) Методы вычислений 216л","(сем) Методы оптимизации и вариационное исчисление 1032л","(сем) Элективный курс по физической культуре и спорту Каф"},
            {},
            {}};
        public static String[][] lessonsBegin = {{"08","30"},{"10","15"},{"12","00"},{"13","50"},{"15","40"},{"17","25"}};
    public static int[] lessonsBeginInMinute = {
            Integer.parseInt(lessonsBegin[0][0]) * 60 + Integer.parseInt(lessonsBegin[0][1]),
            Integer.parseInt(lessonsBegin[1][0]) * 60 + Integer.parseInt(lessonsBegin[1][1]),
            Integer.parseInt(lessonsBegin[2][0]) * 60 + Integer.parseInt(lessonsBegin[2][1]),
            Integer.parseInt(lessonsBegin[3][0]) * 60 + Integer.parseInt(lessonsBegin[3][1]),
            Integer.parseInt(lessonsBegin[4][0]) * 60 + Integer.parseInt(lessonsBegin[4][1]),
            Integer.parseInt(lessonsBegin[5][0]) * 60 + Integer.parseInt(lessonsBegin[5][1])};
        public static String[][] lessonsEnd = {{"10","05"},{"11","50"},{"13","35"},{"15","25"},{"17","15"},{"19","00"}};
    public static int[] lessonsEndInMinute = {
            Integer.parseInt(lessonsEnd[0][0]) * 60 + Integer.parseInt(lessonsEnd[0][1]),
            Integer.parseInt(lessonsEnd[1][0]) * 60 + Integer.parseInt(lessonsEnd[1][1]),
            Integer.parseInt(lessonsEnd[2][0]) * 60 + Integer.parseInt(lessonsEnd[2][1]),
            Integer.parseInt(lessonsEnd[3][0]) * 60 + Integer.parseInt(lessonsEnd[3][1]),
            Integer.parseInt(lessonsEnd[4][0]) * 60 + Integer.parseInt(lessonsEnd[4][1]),
            Integer.parseInt(lessonsEnd[5][0]) * 60 + Integer.parseInt(lessonsEnd[5][1])};
    private Timetable(String day, int date){
        this.date = date;
    }
}
