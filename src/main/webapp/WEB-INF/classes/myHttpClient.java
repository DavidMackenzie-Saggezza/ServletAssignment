import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class myHttpClient {
    public static void get() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet getRequest = new HttpGet("http://localhost:8080/ServletAssignment/myEndpoint");
            httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void put() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPut putRequest = new HttpPut("http://localhost:8080/ServletAssignment/myEndpoint");
            httpClient.execute(putRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete deleteRequest = new HttpDelete("http://localhost:8080/ServletAssignment/myEndpoint");
            httpClient.execute(deleteRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void post() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost("http://localhost:8080/ServletAssignment/myEndpoint");
            httpClient.execute(postRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}