package experiments;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args) {
        Map<Integer, String> mapDebug = new HashMap<Integer, String>();

        mapDebug.put(1, "one");
        mapDebug.put(2, "two");
        mapDebug.put(3, "three");
        mapDebug.put(1, "one_");
        mapDebug.get(3);

    }

}
