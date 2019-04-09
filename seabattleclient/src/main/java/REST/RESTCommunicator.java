package REST;

import Models.Player;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpPost;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RESTCommunicator
{
    private final String url = "http://localhost:8090/zeeslagRegister";

    private final Gson gson = new Gson();

    private final int NOTDEFINED = -1;


    public Player addPlayer(String name, String password) {

        String queryPost = "/player";
        Player player = new Player(name, password);
        ZeeslagResponse response = executeQueryPost(player ,queryPost);
        return response.getPlayer().get(0);
    }

    private ZeeslagResponse executeQueryGet(String queryGet) {

        // Build the query for the REST service
        final String query = url + queryGet;
        System.out.println("[Query Get] : " + query);

        // Execute the HTTP GET request
        HttpGet httpGet = new HttpGet(query);
        return executeHttpUriRequest(httpGet);
    }

    private ZeeslagResponse executeQueryPost(Player playerRequest, String queryPost) {

        // Build the query for the REST service
        final String query = url + queryPost;
        System.out.println("[Query Post] : " + query);

        // Execute the HTTP POST request
        HttpPost httpPost = new HttpPost(query);
        httpPost.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(playerRequest));
            httpPost.setEntity(params);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RESTCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeHttpUriRequest(httpPost);
    }

    private ZeeslagResponse executeQueryPut(Player petRequest, String queryPut) {

        // Build the query for the REST service
        final String query = url + queryPut;
        System.out.println("[Query Put] : " + query);

        // Execute the HTTP PUT request
        HttpPut httpPut = new HttpPut(query);
        httpPut.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(petRequest));
            httpPut.setEntity(params);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RESTCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeHttpUriRequest(httpPut);
    }

    private ZeeslagResponse executeQueryDelete(String queryDelete) {

        // Build the query for the REST service
        final String query = url + queryDelete;
        System.out.println("[Query Delete] : " + query);

        // Execute the HTTP DELETE request
        HttpDelete httpDelete = new HttpDelete(query);
        return executeHttpUriRequest(httpDelete);
    }

    private ZeeslagResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        // Execute the HttpUriRequest
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            ZeeslagResponse zeeslagResponse = gson.fromJson(entityString, ZeeslagResponse.class);
            return zeeslagResponse;
        } catch (IOException e) {
            System.out.println("IOException : " + e.toString());
            ZeeslagResponse zeeslagResponse = new ZeeslagResponse();
            zeeslagResponse.setSuccess(false);
            return zeeslagResponse;
        } catch (JsonSyntaxException e) {
            System.out.println("JsonSyntaxException : " + e.toString());
            ZeeslagResponse zeeslagResponse = new ZeeslagResponse();
            zeeslagResponse.setSuccess(false);
            return zeeslagResponse;
        }
    }
}
