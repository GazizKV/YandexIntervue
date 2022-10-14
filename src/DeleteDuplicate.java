import java.io.*;

public class DeleteDuplicate {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/output.txt"));
        writer.write("");
        writer = new BufferedWriter(new FileWriter("src/output.txt", true));

        String next = "";
        String old = "";
        if (!reader.ready()) return;
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            return;
        }
        if (n == 1) {
            writer.write(reader.readLine());
            writer.flush();
            writer.close();
            return;
        }

        while (reader.ready()) {
            next = reader.readLine();
            if (!next.equals(old)) {
                old = next;
                writer.write(next);
                writer.newLine();
            }
        }
        writer.flush();
        reader.close();
        writer.close();
    }
}
