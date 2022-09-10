package ru.gb;
/*
 2. Напишите функцию, для поиска наиболее длинного общего префикса,
 среди массива строк. Если общего префикса нет, то возвращать пустую строку.
 Пример ["aabb", "aabbb", "aaabb"] - ответ "aa"
 */
public class task2 {
    public static void main(String[] args) {
        // String[] arr = {"aabb", "aabbb", "aaabb"};
        String[] arr = {"aabb", "aabbb", "aabb", "aabbcb", "aabdfbb"};
        PrintArrayString(arr);
        StringBuilder result = FindPrefix(arr);
        if (result.equals("")) {
            System.out.println("Общего префикса нет");
        } else {
            System.out.printf("Общий префикс: %s", result.toString());
        }
    }

    // Поиск общего большего префикса
    private static StringBuilder FindPrefix(String[] arr) {
        StringBuilder prefix = new StringBuilder("");
        // если передан не пустой массив
        if (arr.length != 0) {
            // если передан массив из одного элемента
            if (arr.length == 1) {
                prefix.append(arr[0]);
            } else {
                for (int i = 0; i < arr[0].length(); i++) {
                    prefix.append(arr[0].charAt(i));
                    for (int j = 1; j < arr.length; j++) {
                        if(arr[j].startsWith(prefix.toString())) {
                            continue;
                        } else {
                            // Удаляем последний символ  и возвращаем результат
                            prefix.deleteCharAt(i);
                            return prefix;
                        }
                    }
                }
            }
        }
        return prefix;
    }

    // Печать в терминале массива строк
    private static void PrintArrayString(String[] arr) {
        for (String item : arr) {
            System.out.printf("%s ", item);
        }
        System.out.println("");
    }
}
