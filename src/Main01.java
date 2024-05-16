import java.io.*;
import java.util.*;

public class Main01 {
     /*1) Создайте новый проект и создайте в нем текстовый файл

    2) Придумать алгоритм, который бы записал в файл 100 случайных чисел
    3) Придумать алгоритм, который бы прочитал весь файл и вычислил бы:

            3.1) Сумму всех чисел
    3.2) Самое больше и самое маленькое число
    3.3) Сколько чисел делятся на 2

            4*) Сколько чисел больше соседа слева ("до них") и меньше соседа справа ("после них")
    Пример: 5, 8, 9

            5**) попробовать сделать хоть немного в стиле ООП
          */


    public static void main(String[] args) throws IOException {
        Random random = new Random();
        File file = new File("RunNumber");

        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 100; i++) {
            bufferedWriter.write(Integer.toString(random.nextInt()));
            bufferedWriter.newLine();
        }


        bufferedWriter.close();


        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int[] array = new int[100];
        int i = 0;
        int sum = 0;

        while (true) {
            String line = bufferedReader.readLine();

            if (line == null) {
                break;
            }

            int number = Integer.parseInt(line);
            array[i] = number;
            sum += number;
            i++;
        }

        bufferedReader.close();
        System.out.println("сумма всех чисел" + sum);
        System.out.println(Arrays.toString(array));
        findMinMax((array));
    }


    public static void findMinMax(int[] array) {//найти минимальное максимальное число


        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("минимальное число" + " "+ min);
        System.out.println("максимальное число" +" " + max);
    }
}


