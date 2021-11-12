import java.util.regex.Pattern;

public interface LoadBalancer {
    String getServerIP();

    boolean registerServerIP(String IP);

    default public boolean validIP(String IP) {
        Pattern p = Pattern.compile("[0-9]{1,3}[.]{1}[0-9]{1,3}[.][0-9]{1,3}");
        return p.matcher(IP).find() ? true : false;

        //return InetAddressValidator.getInstance().isValid(IP)
    }

    boolean deRegisterServerIP(String IP);

}
