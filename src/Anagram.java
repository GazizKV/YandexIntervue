import java.io.*;
import java.util.Arrays;

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

        bufferedReader.mark(0);
        int next;
        Integer[] firstMatrix = new Integer[256];
        Arrays.fill(firstMatrix, 0);
        Integer[] secondMatrix = new Integer[256];
        Arrays.fill(secondMatrix, 0);

        while (bufferedReader.ready()) {
            next = bufferedReader.read();
            if (next == 13) {
                break;
            }
            firstMatrix[next]++;
        }
        bufferedReader.skip(1);
        while (bufferedReader.ready()) {
            next = bufferedReader.read();
            if (next == 13) {
                break;
            }
            secondMatrix[next]++;
        }

        if (Arrays.equals(firstMatrix, secondMatrix)) {
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
