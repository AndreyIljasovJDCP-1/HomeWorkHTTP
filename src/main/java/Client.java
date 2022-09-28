import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.List;

public class Client {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(
                    "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats"
            );

            CloseableHttpResponse response = httpClient.execute(request);

            List<Data> posts = mapper.readValue(
                    response.getEntity().getContent(), new TypeReference<>() {
                    });

            posts.stream().
                    filter(data -> data.getUpvotes() != null)
                    .filter(data -> !"0".equals(data.getUpvotes()))
                    .forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}



