import java.util.Scanner;

class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Physics marks: ");
            physics[i] = sc.nextInt();
            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = sc.nextInt();
            System.out.print("Enter Maths marks: ");
            maths[i] = sc.nextInt();

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 75) grade[i] = "B";
            else if (percentage[i] >= 50) grade[i] = "C";
            else grade[i] = "D";
        }

        System.out.println("\nPhy  Chem  Math  %   Grade");
        for (int i = 0; i < n; i++) {
            System.out.println(physics[i] + "   " + chemistry[i] + "   " + maths[i] + "   " + percentage[i] + "   " + grade[i]);
        }

        sc.close();
    }
}