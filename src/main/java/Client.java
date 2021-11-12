import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {

        int NUM_OF_REQUESTS = 20;
        Client client = new Client();

        client.printNextTurn("Random");
        LoadBalancer random = new RandomLB(IPPool.getServerIps());
        client.simulateConcurrentClientRequest(random, NUM_OF_REQUESTS);

/*        client.printNextTurn("Round-Robin");
        LoadBalancer roundRobbin = new RoundRobinLB(IPPool.getServerIps());
        client.simulateConcurrentClientRequest(roundRobbin, NUM_OF_REQUESTS);*/


        System.out.println("Main exits");

    }

    private void simulateConcurrentClientRequest(LoadBalancer loadBalancer, int numOfCalls) {

        IntStream
                .range(0, numOfCalls)
                .parallel()
                .forEach(i ->
                        System.out.println(
                                "IP: " + loadBalancer.getServerIP()
                                + " --- Request from Client: " + i
                                + " --- [Thread: " + Thread.currentThread().getName() + "]")
                );
    }

    private void printNextTurn(String name) {
        System.out.println("---");
        System.out.println("Clients starts to send requests to " + name + " Load Balancer");
        System.out.println("---");
    }

}