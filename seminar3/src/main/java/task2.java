import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */
public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(12);
        integerArrayList.add(52);
        integerArrayList.add(4635);
        integerArrayList.add(34863);
        integerArrayList.add(3);
        integerArrayList.add(7);
        integerArrayList.add(44);
        integerArrayList.add(77);
        integerArrayList.add(99);
        integerArrayList.add(66);
        System.out.println(integerArrayList);
        // Вариант 1. Отсортировать по возрастанию. среднее находим через reduce (аккумулятор как было в python)
        integerArrayList.sort(Comparator.naturalOrder());
        System.out.printf("Минимальное значение: %0$d \n", integerArrayList.get(0));
        System.out.printf("Максимальное значение: %0$d \n", integerArrayList.get(integerArrayList.size() - 1));
        Integer summ1 = integerArrayList.stream().reduce(0,(num1, num2)-> num1 + num2);
        System.out.printf("Среднее значение: %0$.3f \n", ((float) summ1 / integerArrayList.size()));
        // Вариант 2. перебрать массив по индексу и найти min, max, average = summ/size значения
        Integer min = integerArrayList.get(0);
        Integer max = min;
        Integer summ = min;
        for (int i = 1; i < integerArrayList.size(); i++) {
            Integer item = integerArrayList.get(i);
            if (item < min) {
                min = item;
            } else if (item > max) {
                max = item;
            }
            summ += item;
        }
        System.out.printf("Минимальное значение: %0$d \n", min);
        System.out.printf("Максимальное значение: %0$d \n", max);
        System.out.printf("Среднее значение: %0$.3f \n", ((float) summ / integerArrayList.size()));
    }
}
