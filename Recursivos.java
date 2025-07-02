public class Recursivos {
    public static void main(String[] args) {
        int n = 5, resultTribbonacci, resultPell;

        resultTribbonacci = tribonacciRec(n);
        System.out.println(resultTribbonacci);

        resultPell = pellRec(n);
        System.out.println(resultPell);
    }

    // tn = t(n-1) + t(n-2) + t(n-3)
    // t3 = t2(1) + t1(0) + t0(0) // t5 = 4
    // 0, 1, 2, 3, 4, 5, 6, 7, 8
    // 0, 0, 1, 1, 2, 4, 7, 13, 24

    // pn = 2 * p(n-1) + p(n-2)
    // p3 = 2 * p2(2) + p1(1) // p5 = 29
    // 0, 1, 2, 3, 4, 5, 6, 7
    // 0, 1, 2, 5, 12, 29, 70, 169

    public static int tribonacciRec(int n) {
        if (n < 2) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return tribonacciRec(n - 1) + tribonacciRec(n - 2) + tribonacciRec(n - 3);
    }

    public static int pellRec(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return 2 * pellRec(n - 1) + pellRec(n - 2);
    }

}
