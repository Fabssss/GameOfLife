import java.util.Scanner;

public class gameOfLife {

    public static byte dead =0;
    public static byte alive =1;
    static {System.out.println("Enter Matrix Size");}
    static Scanner sc = new Scanner(System.in);
    public static int size = sc.nextInt();


    public static void main(String[] args) {



        int[][] matrix = matrixRandom1(matrixGenerator(size));
        matrixPrinter(matrix,size);

    }
    public static int[][] matrixGenerator(int size) {
        int matrix[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = dead;
            }
        }
        return matrix;
    }
    public static void matrixPrinter(int[][] matrix, int size){
        for (int i=0;i<size;i++) {
            for (int j=0; j<size;j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }
    public static int[][] matrixRandom1(int[][] matrix){
        int random_row;
        int random_columns;
        random_row = (int) (Math.random() * size);
        random_columns = (int) (Math.random() * size);
        while (random_row == 0 || random_row == size-1) {
            break;
        }
        while (random_columns == 0 || random_columns == size-1) {
            break;
        }
        matrix[random_row][random_columns] = 1;

        return matrix;
    }
}
