import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class task1 {
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
        // Вариант 1. с использованием итератора
        for (Iterator<Integer> it = integerArrayList.iterator(); it.hasNext(); ) {
            Integer item = it.next();
            if (item % 2 == 0) {
                it.remove();
            }
        }
        // Вариант 2. с  использованием метода, появившегося в java 8
        // integerArrayList.removeIf(num->(num % 2 == 0));
        System.out.println(integerArrayList);
    }
}
