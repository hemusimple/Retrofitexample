package task.com.smapleretrofit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by SAFACS on 6/16/2018.
 */

public class Utiles {

    public static  String GETURL = "data/reviews.json?apiversion=5.4&passkey=ca8PF3AJj2ez0glC7AO417pZqtzLxlwXQTuCdZioHphCo&Filter=ProductId:10001_10051_11047&Sort=Rating:desc&Limit=100&Include=Products&Stats=Reviews";

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
