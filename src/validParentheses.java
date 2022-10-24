import java.util.Queue;

public class validParentheses {
    public static void main(String[] args) {

    }

    public static boolean validParentheses(String parentheses) {
        int result = 0;
        for (String next : parentheses.split("")) {
            if (next.equals("(")) result++;
            else if (next.equals(")")) result--;
            if (result < 0) return false;
        }
        return result == 0;
    }
}
