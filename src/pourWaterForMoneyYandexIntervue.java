import java.io.*;
import java.util.Arrays;

public class pourWaterForMoneyYandexIntervue {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] orders = new int[n][3];
        for (int i = 0; i < n; i++) {
            orders[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        n = Integer.parseInt(reader.readLine());

        int[][] queries = new int[n][3];

        for (int i = 0; i < n; i++) {
            queries[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder answer = new StringBuilder();
        int sum;
        for (int[] query : queries) {
            sum = 0;
            if (query[2] == 1) {
                for (int[] order : orders) {
                    if (order[0] >= query[0] && order[0] <= query[1]) {
                        sum = sum + order[2];
                    }
                }
            } else {
                for (int[] order : orders) {
                    if (order[1] >= query[0] && order[1] <= query[1]) {
                        sum = sum + order[1] - order[0];
                    }
                }
            }
            answer.append(sum).append(" ");
        }

        System.out.println(answer.toString().trim());


        reader.close();
        writer.close();


    }
}
