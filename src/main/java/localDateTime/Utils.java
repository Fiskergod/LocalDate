package localDateTime;

import java.util.List;

public class Utils {
    public static void printInfo(List<People> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ") " + list.get(i).toString());
        }
    }
}
