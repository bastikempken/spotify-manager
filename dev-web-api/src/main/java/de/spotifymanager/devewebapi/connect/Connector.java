package de.spotifymanager.devewebapi.connect;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Connector {

    private String requestToken;

    private final String clientID = "10c30d8b50cf465999821f8cb01d0201";

    private final String clientSecret = "ebaa5e5a326c4766b138adb813bb7981";

    public String connect(String requestUrl){
        String response = StringUtils.EMPTY;

        if(StringUtils.isBlank(requestToken)){
            generateNewRequestToken();
        }

        response = sendRequest(requestUrl);

        if(hasAccessTokenExpires(response)){
            generateNewRequestToken();
            response = sendRequest(requestUrl);
        }
        return response;
    }

    private void generateNewRequestToken() {
        String response = sendPostRequestForToken();
        JSONObject jsonObject = new JSONObject(response);
        this.requestToken = jsonObject.getString("access_token");
    }

    private String sendPostRequestForToken(){
        try {
            URL obj = new URL("https://accounts.spotify.com/api/token");
            HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Authorization","Basic " +
                    Base64.encodeBase64String(String.format("%s:%s", clientID, clientSecret).getBytes()));

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("grant_type=client_credentials");
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (MalformedURLException e) {
            //todo logging
        } catch (IOException e) {
            //todo logging
        }
        return StringUtils.EMPTY;
    }


    private String sendRequest(String endpoint){

        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + requestToken);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();


            while ((inputLine = inputBufferedReader.readLine()) != null){
                stringBuffer.append(inputLine);
            }
            inputBufferedReader.close();
            return stringBuffer.toString();
        } catch (MalformedURLException e) {
            //todo logging
        } catch (ProtocolException e) {
            //todo logging
        } catch (IOException e) {
            //todo logging
        }
        return StringUtils.EMPTY;
    }

    private boolean hasAccessTokenExpires(String response) {
       JSONObject jsonObject = new JSONObject(response);
       try {
        return StringUtils.equals(jsonObject.getString("status"),"401");
       }catch (JSONException ex){
           return false;
       }
    }
}
