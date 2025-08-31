import java.util.Scanner;

class MultiplicationSixToNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] result = new int[4];
        for (int i = 6; i <= 9; i++) {
            result[i - 6] = num * i;
        }

        for (int i = 6; i <= 9; i++) {
            System.out.println(num + " * " + i + " = " + result[i - 6]);
        }

        sc.close();
    }
}