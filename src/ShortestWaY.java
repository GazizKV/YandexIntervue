import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ShortestWaY {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer[]> map = new HashMap<>();
        String next = null;
        for (int i = 0; i < n; i++) {
            next = reader.readLine();
            Integer[] integers = new Integer[2];
            integers[0] = Integer.parseInt(next.split(" ")[0]);
            integers[1] = Integer.parseInt(next.split(" ")[1]);
            map.put(i, integers);
        }
        int k = Integer.parseInt(reader.readLine());
        String way = reader.readLine();
        int from = Integer.parseInt(way.split(" ")[0]) - 1;
        int to = Integer.parseInt(way.split(" ")[1]) - 1;

        int x = 0;
        int y = 0;
        int pathLength = 0;
        for (int i = from; i < to; i++) {
            x = Math.abs(map.get(i)[0] - map.get(i + 1)[0]);
            y = Math.abs(map.get(i)[1] - map.get(i + 1)[1]);
            if (x + y > k) {
                System.out.println(-1);
                return;
            }
            pathLength = x + y;
        }
        System.out.println(pathLength);
        reader.close();
    }
}
