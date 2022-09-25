/*
Взять за основу реализацию стека, написанную в конце семенара.
Добавить проверку граничных условий и выводить сообщения об ошибках,
если мы пытаемся извлечь элемент из пустого стека, добавить элемент в полностью заполненный стек и тд
*/

import java.util.LinkedList;
import java.util.Random;

public class task1 {
    private LinkedList<Object> stack = new LinkedList<>();

    public static void main(String[] args) {
        Random rn = new Random();
        task1 stack = new task1();
        for (int i = 0; i < 100000000; i++) {
            if (!stack.AddToStack(rn.nextInt(100))) {
                break;
            }
        }
        for (int i = 0; i < 112; i++) {
            Object obj = stack.RemoveFromStack();
            if (obj == null)
                break;
        }
    }

    public boolean AddToStack(Object obj) {
        try {
            this.stack.push(obj);
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Нельзя добавить элемент. Стек полный");
            return false;
        } catch (OutOfMemoryError e) {
            System.out.println("Нельзя добавить элемент. Стек полный");
            return false;
        }
    }

    public Object RemoveFromStack() {
        /*
        Вариант 1. Обработка исключения
         */
        /*
        try {
            return this.stack.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Стек пустой");
            return null;
        }
        */
        /*
        Вариант 2. Проверка встроенным методом
         */
        if (this.stack.isEmpty()) {
            System.out.println("Стек пустой");
            return null;
        }
        return this.stack.pop();
    }
}
