import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int min = Integer.MIN_VALUE;

        Structure structure = new Structure();


        final int N = Integer.parseInt(reader.readLine());
        int first, diff, id;
        String nextLine;
        String[] inputLine;

        for (int i = 0; i < N; i++) {
            nextLine = reader.readLine();
            switch (nextLine.charAt(0)) {
                case 49 -> {
                    inputLine = nextLine.split(" ");
                    first = Integer.parseInt(inputLine[1]);
                    diff = Integer.parseInt(inputLine[2]);
                    id = Integer.parseInt(inputLine[3]);
                    structure.add(id, first, diff);
                }
                case 50 -> {
                    inputLine = nextLine.split(" ");
                    id = Integer.parseInt(inputLine[1]);
                    structure.delete(id);
                }
                case 51 -> {
                    structure.getNextMinElement();
                }
            }
        }


        reader.close();
        writer.close();
    }

    public static class Structure {

        public int minFirst = Integer.MAX_VALUE;

        LinkedHashMap<Progression, Integer> active = new LinkedHashMap<>();
        LinkedHashMap<Progression, Integer> deleted = new LinkedHashMap<>();

        HashMap<Integer, Progression> readProgression = new HashMap<>();

        private void getNextMinElement() {
            HashMap<Integer, Progression> map = new HashMap<>();
            int minFirst = findMinFirstFrom(active.keySet());
            int minId = Integer.MAX_VALUE;
            for (Progression next : active.keySet()) {
                if (next.first == minFirst) {
                    map.put(next.getId(), next);
                }
            }
            for (Integer next : map.keySet()) {
                if (minId > next) minId = next;
            }
            if (map.isEmpty()) return;
            Progression progression = map.get(minId);
            progression.getFirstWithReplace();
            minFirst = Integer.MAX_VALUE;
        }

        private int findMinFirstFrom(Set<Progression> keySet) {
            int min = Integer.MAX_VALUE;
            for (Progression nextProgression : keySet) {
                if (min > nextProgression.first) {
                    min = nextProgression.first;
                }
            }
            return min;
        }

        private void delete(int id) {
            Progression toDelete = readProgression.get(id);
            active.remove(toDelete);
            readProgression.remove(id);
            deleted.put(toDelete, id);
        }

        private void add(int id, int first, int diff) {
            Progression toPut = new Progression(id, first, diff);
            active.put(toPut, id);
            readProgression.put(id, toPut);
        }

    }

    public static class Progression {

        int id;
        int first;
        int diff;

        Progression(int id, int first, int diff) {
            this.id = id;
            this.first = first;
            this.diff = diff;
        }

        public void getFirstWithReplace() {
            System.out.println(first);
            first = first + diff;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getDiff() {
            return diff;
        }

        public void setDiff(int diff) {
            this.diff = diff;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Progression that = (Progression) o;
            return id == that.id && first == that.first && diff == that.diff;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, first, diff);
        }

        @Override
        public String toString() {
            return "Progression{" +
                    "id=" + id +
                    ", first=" + first +
                    ", diff=" + diff +
                    '}';
        }
    }
}
