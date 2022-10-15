import java.io.*;
import java.util.HashMap;

public class Anagram {

    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;

    static {
        try {
            bufferedReader = new BufferedReader(new FileReader("src/input.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("src/output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String abc = "abcdefghijklmnopqrstuvwxyz";

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map1.put(abc.charAt(i), 0);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map2.put(abc.charAt(i), 0);
        }

        char nextChar;
        String next;
        while (bufferedReader.ready()) {
            nextChar = (char) bufferedReader.read();
            if (nextChar == 13) {
                break;
            }
            map1.put(nextChar, map1.get(nextChar) + 1);
        }
        bufferedReader.read();
        while (bufferedReader.ready()) {
            nextChar = (char) bufferedReader.read();
            if (nextChar == 13) {
                break;
            }
            map2.put(nextChar, map2.get(nextChar) + 1);
        }

        if (map1.equals(map2)) {
            bufferedWriter.write("1");
        } else {
            bufferedWriter.write("0");
        }
        close();
    }

    public static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }
}
