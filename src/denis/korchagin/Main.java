package denis.korchagin;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        double x = readX();
        int n = readN();
        double e = readE();
        calcSumFirstMembers(x, n);
        calcSumMembersGreaterThanE(x, e);
        calcSumMembersGreaterThanE(x, e / 10);
        calcArcTan(x);
    }

    static double readX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input x ");
        return scanner.nextDouble();
    }

    static int readN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n ");
        return scanner.nextInt();
    }

    static double readE() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input e ");
        return scanner.nextDouble();
    }

    static double calcPresentMember(double x, double pastMember, int i) {
        return calcNumeratorNumber(x, pastMember, i) / calcDenominatorNumber(i);
    }

    static double calcNumeratorNumber(double x, double pastMember, int i) {
        return  (-1) * pastMember * Math.pow(x, 2) * (2 * i - 3);
    }

    static double calcDenominatorNumber(int i) {
        return (2 * i - 1);
    }

    static void calcSumFirstMembers(double x, int n) {
        double presentMember = x;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            double pastMember = presentMember;
            sum += presentMember;
            presentMember = calcPresentMember(x, pastMember, i + 1);
        }
        printSumFirstMembers(sum, n, x);
    }

    static void printSumFirstMembers(double sum, int n, double x) {
        System.out.printf("Sum %d first members  = %.2f for x = %.2f\n", n, sum, x);
    }

    static void calcSumMembersGreaterThanE(double x, double e) {
        double presentMember = x;
        double sum = 0;
        for (int i = 1; ; i++) {
            double pastMember = presentMember;
            if (Math.abs(presentMember) <= e) {
                printSumMembersGreaterThanE(sum, i - 1, e, x);
                return;
            }
            sum += presentMember;
            presentMember = calcPresentMember(x, pastMember, i + 1);
        }
    }

    static void printSumMembersGreaterThanE(double sum, int i, double e, double x) {
        System.out.printf("%d members greater than %.4f, their sum = %.4f for x = %.4f\n", i, e, sum, x);
    }

    static void calcArcTan(double x) {
        double result = Math.atan(x);
        printArcTan(x, result);
    }

    static void printArcTan(double x, double result) {
        System.out.printf("ArcTan %.4f = %.4f\n", x, result);
    }
}
