import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;
        int maxLength = 0;
        int nextSequence = 0;
        int nextNumber = 0;

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            nextNumber = Integer.parseInt(reader.readLine());
            if (nextNumber == 1) {
                nextSequence++;
            } else {
                nextSequence = 0;
            }
            if (nextSequence > maxLength) {
                maxLength = nextSequence;
            }
        }

        System.out.println("\n" + maxLength);

    }
}