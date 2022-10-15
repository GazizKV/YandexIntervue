import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstStr = reader.readLine();
        int n = Integer.parseInt(firstStr.split(" ")[0]);
        double square = Double.parseDouble(firstStr.split(" ")[1]);
        double side = Math.round(Math.sqrt(square));
        int counter = 0;

        StringBuilder result = new StringBuilder();
        String nextStr;
        double x, y;

        for (int i = 0; i < n; i++) {
            nextStr = reader.readLine();
            x = Double.parseDouble(nextStr.split(" ")[0]);
            y = Double.parseDouble(nextStr.split(" ")[1]);
            if (x <= side && y <= (int) side) {
                counter++;
                result.append(i + 1).append(" ");
            }
        }
        String answer = counter + "\n" + result.toString().strip();
        writer.write(answer);

        reader.close();
        writer.close();
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(reader.readLine());
//        int sideSize = 2 * n + 1;
//        int[][] matrix = new int[sideSize][sideSize];
//
//        int black = -1;
//        int white = 1;
//        for (int i = 0; i < sideSize; ++i) {
//            for (int j = 0; j < sideSize; ++j) {
//                if ( i == j) {
//                    matrix[i][j] = 0;
//                } else if (i % 2 == 0) {
//                    if (j % 2 == 0) {
//                        matrix[j][i] = black--;
//                    } else {
//                        matrix[i][j] = white++;
//                    }
//                } else {
//                    if (j % 2 == 0) {
//                        matrix[i][j] = white++;
//                    } else {
//                        matrix[j][i] = black--;
//                    }
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < sideSize; i++) {
//            for (int j = 0; j < sideSize; j++) {
//                sb.append(matrix[i][j]).append(" ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb.toString().strip());
//
//        reader.close();
//        writer.close();
//    }

}
