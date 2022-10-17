import java.io.*;
import java.util.*;

public class FromRagToClient {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] next;
        String status;
        int hour, day, minute;
        long id;

        TreeMap<Long, TreeMap<Calendar, String>> map = new TreeMap<>();
        Calendar calendar = new GregorianCalendar();

        for (int i = 0; i < n; i++) {
            next = reader.readLine().split(" ");
            id = Integer.parseInt(next[3]);
            status = next[4];
            day = Integer.parseInt(next[0]);
            hour = Integer.parseInt(next[1]);
            minute = Integer.parseInt(next[2]);
            calendar = new GregorianCalendar();
            calendar.setTimeInMillis(0l);
            calendar.set(Calendar.DAY_OF_YEAR, day);
            calendar.set(Calendar.HOUR, hour);
            calendar.set(Calendar.MINUTE, minute);
            if (map.containsKey(id)) {
                map.get(id).put(calendar, status);
            } else {
                map.put(id, new TreeMap<Calendar, String>());
                map.get(id).put(calendar, status);
            }
        }
        StringBuilder result = new StringBuilder();
        for (TreeMap<Calendar, String> nextTree : map.values()) {
            long millis = 0l;
            long sum = 0;
            for (Map.Entry<Calendar, String> pair : nextTree.entrySet()) {
                if (pair.getValue().equals("A")) {
                    millis = pair.getKey().getTimeInMillis();
                } else if (pair.getValue().equals("C") || pair.getValue().equals("S")) {
                    millis = pair.getKey().getTimeInMillis() - millis;
                    sum = sum + millis;
                    millis = 0;
                }
            }
            result.append(sum / 60 / 1000).append(" ");
        }
        System.out.println(result.toString().trim());

        reader.close();
        writer.close();

    }
}
