public class Main {
    public static final int AMOUNT_TREES = 20;
    public static final int LEVELS_OF_TREES = 6;

    public static void main(String[] args) {
        // 1. Создание и заполнение деревьев случайными числами.
        BinaryTreeSet[] arr = new BinaryTreeSet[AMOUNT_TREES];
        for (int i=0; i < AMOUNT_TREES; i++) {
            arr[i] = new BinaryTreeSet<Integer,Integer>();
            for (int j=0; j < power(2,LEVELS_OF_TREES)-1; j++) {
                int temp = (int)(Math.random() * 200 - 100);
                arr[i].put(temp,temp);
            }
        }
        System.out.println(arr[0]);

       // 2. Расчет процента несбалансированных деревьев.
        int percent = analyze(arr, LEVELS_OF_TREES);
        System.out.println("Процент несбалансированных деревьев: " + percent);
    }

    public static int analyze(BinaryTreeSet[] arr, int levels) {
        int notBalance = 0;
        for (int i=0; i < arr.length; i++) {
            int leftTemp = arr[i].getLeftCount();
            int rightTemp = arr[i].getRightCount();
            if (leftTemp != rightTemp) {
                notBalance++;
            }
        }
        return notBalance * 100 / arr.length;
    }

    public static int power (int base, int power) {
        int result = 1;
        for (int i=0; i < power; i++) {
            result *= base;
        }
        return result;
    }
}
