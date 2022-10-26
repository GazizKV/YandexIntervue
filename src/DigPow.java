public class DigPow {
    public static void main(String[] args) {
        System.out.println(digPow(1, 1));
    }


    public static long digPow(int n, int p) {
        if (n == 1) return 1;
        String digits = String.valueOf(n);
        long sumPow = 0l;
        for (int i = 0; i < digits.length(); ++i) {
            sumPow = sumPow + pow(Long.parseLong(String.valueOf(digits.charAt(i))), p);
            p += 1;
        }
        for (int i = 1; i < sumPow; ++i) {
            if (sumPow % i == 0 && sumPow / i == n) {
                return i;
            }
        }
        return -1;
    }

    public static long pow(long number, int pow) {
        long result = 1l;
        for (int i = 0; i < pow; ++i) {
            result = result * number;
        }
        return result;
    }

}
