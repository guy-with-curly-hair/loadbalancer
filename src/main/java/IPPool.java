import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class IPPool {

    private static Map<String, Integer> map = new ConcurrentHashMap<>();
    private static Map<String, Integer> weightedIPMap = new ConcurrentHashMap<>();

    static {
        map.put("192.31.45.56", 1);
        map.put("192.31.45.57", 1);
        map.put("192.31.45.58", 1);
        map.put("192.31.45.59", 1);
        map.put("192.31.45.60", 1);
        map.put("192.31.45.61", 1);
        map.put("192.31.45.62", 1);
        map.put("192.31.45.63", 1);
        map.put("192.31.45.64", 1);
        map.put("192.31.45.65", 1);
    }

    static {
        weightedIPMap.put("192.31.45.56", 6);
        weightedIPMap.put("192.31.45.57", 3);
        weightedIPMap.put("192.31.45.58", 1);

    }


    public static List<String> getServerIps() {

        return map.keySet().stream().sorted().collect(Collectors.toList());
    }

    public static List<String> getWeightedServerIps() {

        return weightedIPMap.keySet().stream().map(ip ->
        {
            List<String> l = new ArrayList<>();
            for ( int i=0; i < weightedIPMap.get(ip);i++)
                l.add(ip);
             return l;
        }).flatMap( st -> st.stream()).sorted().collect(Collectors.toList());
    }
}
