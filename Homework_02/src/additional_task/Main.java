package additional_task;

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(7);
        matrix.fill();
        matrix.print();
    }

}

class Matrix {
    private int count = 0;
    private int size;
    private int[][] matrix;

    Matrix(int dimension) {
        size = dimension;
        matrix = new int[size][size];
    }

    void fill() {
        for (int k = 0; k < size - 2; k++) {
            int i, j;
            // left -> right
            i = k;
            for (j = i; j < size-k; j++) {
                matrix[i][j] = ++count;
            }

            // up -> down
            j = size - k - 1;
            for (i = k + 1; i < size - k; i++) {
                matrix[i][j] = ++count;
            }

            // right -> left
            i = size - k - 1;
            for (j = size - 2 - k; j >= k; j--) {
                matrix[i][j] = ++count;
            }

            // down -> up
            j = k;
            for (i = size - 2 - k; i >= k + 1; i--) {
                matrix[i][j] = ++count;
            }
        }
    }

    void print() {
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}