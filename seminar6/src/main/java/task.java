/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры
фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;

public class task {

    public static void main(String[] args) {
        // Задаем начальный список ноутбуков
        List<notebook> notebookList = new LinkedList<>();
        notebookList.add(new notebook("hp","i5",8,256,"white", "windows"));
        notebookList.add(new notebook("lenovo","i3",4,512,"black", "linux"));
        notebookList.add(new notebook("asus","i9",16,512,"grey", "windows"));
        notebookList.add(new notebook("iRU","pentium",4,256,"silver", "dos"));
        notebookList.add(new notebook("baykal","celeron",4,128,"white", "dos"));
        notebookList.add(new notebook("ibm","i5",32,1024,"black", "macos"));
        notebookList.add(new notebook("iRU","pentium",4,256,"silver"));
        notebookList.add(new notebook("baykal","celeron",4,128,"white"));

        // выводим исходный список ноутбуков
        for (notebook item: notebookList) {
            System.out.println(item);
        }

        // Описываем используемые критерии фильтрации
        Map<Integer, String> criteri = new TreeMap<>(Map.of(1, "ОЗУ",
                                                            2, "Объем ЖД",
                                                            3, "Операционная система",
                                                            4, "Цвет"));

        // инициализируем фильтр по которому будем фильтровать
        Map<String, Object> filter = new HashMap<>();
        filter.put("memory", (int) 0);
        filter.put("hardDisk", (int) 0);
        filter.put("color", null);
        filter.put("operationSystem", null);

        // Получаем фильтр, который заполнил пользователь
        filter = inputFilter(criteri);

        // делаем выбор из списка ноутбуков по установленным значениям фильтра
        List<notebook> result = selectNotebook(filter, (LinkedList<notebook>) notebookList);

        // выводим результат фильтрации
        for (notebook item: result) {
            System.out.println(item);
        }
    }

    public static Map<String,Object> inputFilter(Map<Integer, String> criteri) {
        int selectValue = 0;
        Map<String, Object> filter = new HashMap<>();
        filter.put("memory", (int) 0);
        filter.put("hardDisk", (int) 0);
        filter.put("color", null);
        filter.put("operationSystem", null);

        Scanner scn = new Scanner(System.in, "Cp866");
        for (; ; ) {
            System.out.println("Веедите цифру, соответствующую необходимому критерию или 0 для выхода:");
            for (Map.Entry<Integer, String> item : criteri.entrySet()) {
                System.out.println(item.getKey() + " - " + item.getValue());
            }
            try {
                selectValue = Integer.parseInt(scn.nextLine());
                if ((selectValue < 0) || (selectValue > criteri.size())) {
                    System.out.println("Критерий не выбран");
                    continue;
                }
                if (selectValue == 0) {
                    return filter;
                }
            } catch (Exception e) {
                System.out.println("Введено не цифра");
                break;
            }
            System.out.println("Введите минимальное значение критерия для поиска:");
            try {
                String valueInput = scn.nextLine();
                if (selectValue == 1) {
                    int findValue = Integer.parseInt(valueInput);
                    filter.put("memory",findValue);
                }
                if (selectValue == 2) {
                    int findValue = Integer.parseInt(valueInput);
                    filter.put("hardDisk",findValue);
                }
                if (selectValue == 3) {
                    filter.put("operationSystem",valueInput);
                }
                if (selectValue == 4) {
                    filter.put("color",valueInput);
                }
            } catch (Exception e) {
                System.out.println("Что-то не так с введенным значением" + e.getLocalizedMessage());
                break;
            }
        }
        return filter;
    }

    public static List<notebook> selectNotebook (Map<String,Object> filter, LinkedList<notebook> notebookList) {
        List<notebook> resultSelect = new LinkedList<>();
        for (notebook item: notebookList) {
            if (item.like(filter)) {
                resultSelect.add(item);
            }
        }
        return resultSelect;
    }
}
