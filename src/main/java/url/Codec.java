package url;

import java.util.HashMap;
import java.util.Random;
import java.lang.StringBuilder;

public class Codec {

     //HashMap to store the longUrl and the randomly generated string
     HashMap<String,String> urlMap = new HashMap<>();  

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random rand = new Random();
        int urlLen = 6;
        char [] shortURL = new char[urlLen];
        String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        for(int i = 0; i < urlLen; i++ )
            shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

        StringBuilder sb = new StringBuilder("http://tinyurl.com/");
        sb.append(new String(shortURL));
        System.out.println(sb);

        urlMap.put(sb.toString(),longUrl);

        return sb.toString();

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

            return urlMap.get(shortUrl);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));