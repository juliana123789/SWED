public class UlamFunction {

    public static boolean ulamEndsAtOne(long n) {
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int LIMIT = 1000000;

        for (int i = 1; i < LIMIT; i++) {
            if (!ulamEndsAtOne(i)) {
                System.out.println("Ulam function failed at number: " + i);
                return;
            }
        }

        System.out.println("The Ulam function terminates with 1 for any given positive integer n<1M.");
    }
}
