package ru.gb;

/**
 1. Задан массив, например, nums = [1,7,3,6,5,6].
 Написать программу, которая найдет индекс i для этого массива такой,
 что сумма элементов с индексами < i равна сумме элементов с индексами > i.
 */
public final class task1 {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int result = FindIndexEqualSumm(nums);
        if(result<0){
            System.out.println("Такого индекса не существует");
        } else {
            System.out.printf("Индекс равен: %d", result);
        }
    }

   private static int FindIndexEqualSumm(int[] arr) {
    int summ_nums = 0;
    int summ_arr = 0;
    int result = -1;

    // Подсчитываем сумму всех элементов массива
    for (int i = 0; i < arr.length; i++) {
        summ_arr += arr[i];
    }

    // поиск индекса i для которого сумма элементов с индексами < i равна сумме элементов с индексами > i
    for (int i = 0; i < arr.length; i++) {
        summ_nums += arr[i];
        if (((i + 1) < arr.length) && (summ_nums == (summ_arr - summ_nums - arr[i + 1]))) {
            result = i + 1;
            break;
        }
    }
    return result;
   }
}
