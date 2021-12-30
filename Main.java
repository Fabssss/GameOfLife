public class Main
{
    public static void main(String[] args) {

    }
    public static int[][] matrixGenerator(){
        int rows = 20;
        int columns = 20;
        int matrix[][] = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    return matrix;}  
}