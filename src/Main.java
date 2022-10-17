import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstStr = reader.readLine();
        int n = Integer.parseInt(firstStr.split(" ")[0]);
        int square = Integer.parseInt(firstStr.split(" ")[1]);
        String next;
        HashMap<Integer, Integer[]> map = new HashMap<>();
        int x, y, counter = 0, duplX = 0, duplY = 0;
        boolean isDuplicate = false;

        for (int i = 0; i < n; i++) {
            next = reader.readLine();
            x = Integer.parseInt(next.split(" ")[0]);
            y = Integer.parseInt(next.split(" ")[1]);
            map.put(i + 1, new Integer[]{x, y});
        }

        HashMap<Integer, Integer[]> result = new HashMap<>();
        for (Map.Entry<Integer, Integer[]> nextPair : map.entrySet()) {
            x = duplX = nextPair.getValue()[0];
            y = duplY = nextPair.getValue()[1];

            if (x == 0) x = 1;
            if (y == 0) y = 1;
            if (x * y <= square) {
                for (Map.Entry<Integer, Integer[]> entry : result.entrySet()) {
                    if (entry.getValue()[0] == duplY && entry.getValue()[1] == duplX) {
                        isDuplicate = true;
                    }
                }
                if (isDuplicate) {
                    isDuplicate = false;
                    continue;
                }
                result.put(nextPair.getKey(), nextPair.getValue());
                counter++;
            }
        }


        System.out.println(counter);
        for (Map.Entry<Integer, Integer[]> nextPair : result.entrySet()) {
            System.out.print(nextPair.getKey() + " ");
        }


        reader.close();
        writer.close();
    }

}
