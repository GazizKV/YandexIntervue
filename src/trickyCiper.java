import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class trickyCiper {
    public static String HEXADECIMALS = "0123456789ABCDEF";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        int n = Integer.parseInt(reader.readLine());
        String[] array = new String[n];
        StringBuilder answers = new StringBuilder();
        int charNumbers, sumBirthDigit, firstCharFIOBy256, mainSum, j = 0;
        StringBuilder hexadecimal;
        HashSet<String> set = null;

        for (int i = 0; i < n; i++) {
            array[i] = reader.readLine();
        }
        for (String next : array) {
            set = new HashSet<String>();
            String[] nextLine = next.split(",");
            set.addAll(Arrays.asList(nextLine[0].split("")));
            set.addAll(Arrays.asList(nextLine[1].split("")));
            set.addAll(Arrays.asList(nextLine[2].split("")));
            charNumbers = set.size();
            sumBirthDigit = Arrays.stream(nextLine[3].split("")).map(Integer::parseInt).reduce(0, Integer::sum) +
                    Arrays.stream(nextLine[4].split("")).map(Integer::parseInt).reduce(0, Integer::sum);
            firstCharFIOBy256 = (alphabet.indexOf(nextLine[0].substring(0, 1).toLowerCase()) + 1) * 256;
            mainSum = charNumbers + sumBirthDigit * 64 + firstCharFIOBy256;
            hexadecimal = new StringBuilder(getHexaDecimal(mainSum));
            if (hexadecimal.length() >= 3) {
                answers.append(hexadecimal.substring(hexadecimal.length() - 3)).append(" ");
            } else if (hexadecimal.length() == 0) {
                answers.append("000").append(" ");
            } else {
                while (hexadecimal.length() < 3) {
                    hexadecimal.insert(0, "0").append(" ");
                }
                answers.append(hexadecimal.toString()).append(" ");
            }

        }

        System.out.println(answers.toString().strip());


        reader.close();
        writer.close();
    }

    private static String getHexaDecimal(int number) {
        StringBuilder result = new StringBuilder();
        int nextDigit = 0;
        while (number > 0) {
            nextDigit = number % 16;
            result.insert(0, HEXADECIMALS.substring(nextDigit, nextDigit + 1));
            number = number / 16;
        }
        return result.toString();
    }


}
