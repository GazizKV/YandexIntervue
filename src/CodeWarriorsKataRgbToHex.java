public class CodeWarriorsKataRgbToHex {
    public static void main(String[] args) {
    }
    public static String rgb(int r, int g, int b) {
        return decimalToHex(r) + decimalToHex(g) + decimalToHex(b);
    }

    public static String decimalToHex(int number) {
        final String HEXA = "0123456789ABCDEF";
        if (number > 255) return "FF";
        if (number == 0 || number < 0) return "00";
        return HEXA.substring(number / 16 % 16, number / 16 % 16 + 1) +
                HEXA.substring(number % 16, number % 16 + 1);
    }
}
