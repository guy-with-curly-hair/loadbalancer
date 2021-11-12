import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomLBTest {
    LoadBalancer l1 = new RandomLB(IPPool.getServerIps());
    LoadBalancer l2 = new RoundRobinLB(IPPool.getServerIps());


    @Test
    void getServerIP() {
    }

    @Test
    void registerServerIP() {
    }
}