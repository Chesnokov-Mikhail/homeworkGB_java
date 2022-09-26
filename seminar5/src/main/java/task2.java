/*
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
 */

import java.util.*;

public class task2 {
    public static LinkedList<String> employee = new LinkedList<>(List.of(
                                                    "Иван Иванов",
                                                    "Светлана Петрова",
                                                    "Кристина Белова",
                                                    "Анна Мусина",
                                                    "Анна Крутова",
                                                    "Иван Юрин",
                                                    "Петр Лыков",
                                                    "Павел Чернов",
                                                    "Петр Чернышов",
                                                    "Мария Федорова",
                                                    "Марина Светлова",
                                                    "Мария Савина",
                                                    "Мария Рыкова",
                                                    "Марина Лугова",
                                                    "Анна Владимирова",
                                                    "Иван Мечников",
                                                    "Петр Петин",
                                                    "Иван Ежов"
                                                    ));

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap = countName(employee);
        // вывод повторяющихся имен с количеством повторений
        System.out.println(treeMap);
        // вывод повторяющихся имен с количеством повторений по убыванию популярности
        System.out.println(descendingMapValue(treeMap));
    }

    public static TreeMap<String, Integer> countName(LinkedList strList) {
        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>();
        int count = 0;
        for (String item: employee) {
            String[] strArray = item.split(" ");
            if (stringIntegerTreeMap.containsKey(strArray[0])) {
                count = stringIntegerTreeMap.get(strArray[0]) + 1;
                stringIntegerTreeMap.put(strArray[0], count);
            } else {
                stringIntegerTreeMap.put(strArray[0], 1);
            }
        }
        return stringIntegerTreeMap;
    }

    // сортировка map по значению с использованием set
    public static TreeSet <Map.Entry> descendingMapValue (TreeMap<String, Integer> dict) {
        // Компаратор для сравнения значений map и размещения entry по убыванию
        Comparator <Map.Entry> comparator = new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                if (((int) o1.getValue()) < ((int) o2.getValue())) {
                    return 1;
                } else if (((int) o1.getValue()) > ((int) o2.getValue())) {
                    return -1;
                }
                return 1;
            }
        };

        TreeSet <Map.Entry> ts = new TreeSet(comparator);

        ts.addAll(dict.entrySet());

        return ts;
    }
}
