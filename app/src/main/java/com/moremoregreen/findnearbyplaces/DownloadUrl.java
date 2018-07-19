package com.moremoregreen.findnearbyplaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {
    public String ReadTheURL(String placeURL) throws IOException {
        String Data = "";
        InputStream is = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(placeURL);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            is = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";

            while ((line = br.readLine()) != null) {
                stringBuffer.append(line);
            }
            Data = stringBuffer.toString();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            httpURLConnection.disconnect();
        }
        return Data;
    }
}
