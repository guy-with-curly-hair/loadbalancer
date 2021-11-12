import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class weightedRoundRobinLB implements LoadBalancer {

    List<String> s;// = new ArrayList<>();
    volatile AtomicInteger i = new AtomicInteger(0);

    public weightedRoundRobinLB(List<String> s) {
        this.s = s;
    }

    @Override
    public String getServerIP() {
        System.out.println("before atomic value " + i);
        i.compareAndSet(s.size(), 0);
        System.out.println("After atomic value " + i);
        int index =i.getAndIncrement();
        System.out.println("After atomic value increment  " + index);

        return s.get(index);
    }

    @Override
    public boolean registerServerIP(String IP) {
        if(!validIP(IP))
            return false;

        if (!s.contains(IP))
            s.add(IP);
        return false;
    }

    @Override
    public boolean deRegisterServerIP(String IP) {
        if (s.contains(IP)) {
            s.remove(IP);
            return true;
        }
        return false;
    }
}
