package connectionUtils;

import restAssuredUtil.RestAssuredUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtils {


    /**
     *
     * @return
     */
    public static int getResponseCodeForURLConnection() {
        int responseCode = 0;
        HttpURLConnection huc;
        try {
            URL url = new URL(RestAssuredUtil.getBaseURIString());
            huc = (HttpURLConnection) url.openConnection();
            responseCode = huc.getResponseCode();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return responseCode;
    }

}
