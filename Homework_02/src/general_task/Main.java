package general_task;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array();
        arr.fillRandom();
        System.out.println();

        long t0, tk, delta;
        t0 = System.currentTimeMillis();
        arr.sortBubble();
        tk = System.currentTimeMillis();
        delta = tk - t0;
        System.out.println("Время выполнения сортировки пузырьком: " + delta); //17678 мс для 100000*/

        t0 = System.currentTimeMillis();
        arr.sortSelect();
        tk = System.currentTimeMillis();
        delta = tk - t0;
        System.out.println("Время выполнения сортировки методом выбора: " + delta); //937 мс для 100000

        t0 = System.currentTimeMillis();
        arr.sortInsert();
        tk = System.currentTimeMillis();
        delta = tk - t0;
        System.out.println("Время выполнения сортировки методом вставки: " + delta); //2 мс для 100000

    }
}

class Array {
    // 1. Создать массив большого размера (миллион элементов).
    private static int count = 0;
    int[] array = new int[100000];


    // 2. Написать методы удаления, добавления, поиска элемента массива.
    void add (int element) {
        array[count] = element;
        count++;
    }

    int search (int element) {
        int index = -1;
        for (int i=0; i < array.length; i++) {
            if (array[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    void remove (int element) {
        int index = search(element);
        shift(index);
        int length = array.length-1;
        for (int i=0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void shift(int start) {
        int temp = array[start];
        for (int i=start; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = temp;
    }

    void print() {
        for (int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // 3. Заполнить массив случайными числами.
    void fillRandom() {
        for (int i=0; i < array.length; i++) {
            array[i] = (int)(Math.random() * array.length);
        }
    }

    // 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
    void sortBubble () {
        for (int i= array.length-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap (int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void sortSelect () {
        int mark;
        for(int i=0; i < array.length; i++){
            mark = i;
            for(int j = i+1; j < array.length; j++){
                if (array[j] < array[mark]){
                    mark = j;
                }
            }
            swap(i, mark);
        }
    }

    public void sortInsert () {
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j-1] >=temp) {
                array[j] = array[j-1];
                --j;
            }
            array[j] = temp;
        }
    }




}
