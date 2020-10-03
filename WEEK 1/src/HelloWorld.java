import java.util.Arrays;
import java.util.Random;


public class HelloWorld {
    public static void main(String[] args) {

        //int[] intArray = new int[10];
        //populateOdd(intArray);
        //System.out.println(Arrays.toString(intArray));
        int[][] arr = populate2D(2, 5);
        print2DArray(arr);
        sortSecondDigit(arr);
        print2DArray(arr);

    }

    public static int[] populateOdd(int[] intArray) {
        int odd = 1;
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = (i < 1) ? odd : intArray[i - 1] + 2;
        return intArray;
    }

    public static int[][] populate2D(int n, int m) {
        Random rand = new Random();
        int[][] arr = new int[n][m];
        int odd = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // arr[i][j] = (j < 1) ? odd : arr[i][j - 1] + 2;
                arr[i][j] = rand.nextInt(1000);
            }
        }
        return arr;
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }

    public static void firstEx() {
        int[] arr = {3, 4, 2};
        System.out.println(Arrays.toString(arr));
    }

    public static int[][] sortFirstDigit(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i].length;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - j - 1; k++) {
                    if (firstDigit(arr[i][k]) > firstDigit(arr[i][k + 1])) {
                        int temp = arr[i][k];
                        arr[i][k] = arr[i][k + 1];
                        arr[i][k + 1] = temp;
                    }
                }
            }
        }


        return arr;

    }

    public static int firstDigit(int n) {
        // Remove last digit from number
        // till only one digit is left
        while (n >= 10)
            n /= 10;

        // return the first digit
        return n;
    }

    /*
     This function is a bubble sort to sort the first digit
     */

    public static int[][] sortSecondDigit(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i].length;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - j - 1; k++) {
                    char[] firstNum = String.valueOf(arr[i][k]).toCharArray();
                    char[] secondNum = String.valueOf(arr[i][k + 1]).toCharArray();
                    int n1=firstNum.length;
                    int n2=secondNum.length;
                    if (getNthDigit(arr[i][k],10,n1-1) > getNthDigit(arr[i][k + 1],10,n2-1)) {
                        int temp = arr[i][k];
                        arr[i][k] = arr[i][k + 1];
                        arr[i][k + 1] = temp;
                    }
                }
            }
        }


        return arr;

    }

    public static int getNthDigit(int number, int base, int n) {
        return (int) ((number / Math.pow(base, n - 1)) % base);
    }


}
