import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class codeWarsKataRegExp {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add(":)"); a.add(":D"); a.add(":-}"); a.add(":-()");
        int res = countSmileys(a);
        System.out.println(res);
    }
    
    public static int countSmileys(List<String> arr) {
        int count = 0;
        Pattern p = Pattern.compile("[:;]{1}[-~]??[\\)D]{1}");
        for (int i = 0; i < arr.size(); i++) {
            Matcher m = p.matcher(arr.get(i));
            if (m.matches()) {
                count++;
            }
        }
        return count;
    }
}
