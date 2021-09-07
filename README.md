# MyTimetable

## Идея
Это приложение показывает мое текущее расписание занятий.

## Технологии
В качестве архитектуры приложения выбран паттерн MVVM. Технологии, которые используются в проекте:
* Dagger 2

## Скриншоты
При запуске на главном экране приложения находится RecyclerView с текущими занятиями. Кнопки вперед и назад смещают дату на один день и позволяют увидеть, какие занятия будут дальше. В верхнем правом углу на Toolbar находится кнопка, при нажатии на которую откроется Activity для редактирования расписания.

<img src="https://github.com/avelycure/avelycure/blob/master/assets/timetable/Timetable.jpg" width="320" />

Activity для редактирования расписания представляет собой RecyclerView, в каждый элемент которого вложен еще один RecyclerView. RadioButton позволяет выбрать тип недели: числитель или знаменатель. Внизу фрагмента находится кнопка Сохранить, при нажатии на нее содержимое активного фрагмента сохраняется в файл.

<img src="https://github.com/avelycure/avelycure/blob/master/assets/timetable/edit_timetable1.jpg" width="320" />
<img src="https://github.com/avelycure/avelycure/blob/master/assets/timetable/edit_timetable2.jpg" width="320" />
