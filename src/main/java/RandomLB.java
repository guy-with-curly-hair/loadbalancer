import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLB implements LoadBalancer {
    private static int size = 10;
    private static List<String> list;

    public RandomLB(List<String> ips) {
        list = new ArrayList<>(ips);
    }

    @Override
    public String getServerIP()  {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    @Override
    public boolean registerServerIP(String IP) {
        if (validIP(IP))
            list.add(IP);
        throw new IllegalArgumentException(IP);
    }

    @Override
    public boolean deRegisterServerIP(String IP) {
        if (list.contains(IP)) {
            list.remove(IP);
            return true;
        }
        return false;
    }


}
