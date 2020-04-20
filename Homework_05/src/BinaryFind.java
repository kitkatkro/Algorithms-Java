import java.util.NoSuchElementException;

public class BinaryFind {
    public static void main(String[] args) {
        Array array = new Array();
        System.out.println(array.find(-500, 0, array.size));

   }

   static class Array {
        private int[] array = {-1000, -500, -250, -100, -50, -10, -5, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        public int size = array.length;

        public int find(int search, int low, int high) {
           int mark = (low + high) / 2;
           if (array[mark] == search) {
               return mark;
           } else {
               if (low > high) {
                   throw new NoSuchElementException("В массиве отсутствует заданный элемент");
               } else {
                   if (array[mark] < search) {
                       return find(search, mark + 1, high);
                   } else {
                       return find(search, low, mark - 1);
                   }
               }
           }

       }
   }


}
