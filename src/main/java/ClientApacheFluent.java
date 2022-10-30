import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

public class ClientApacheFluent {
    public static final String CATS_URI
            = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            HttpResponse response = Request.Get(CATS_URI)
                    .execute()
                    .returnResponse();
            System.out.println(response.getStatusLine());

            List<Data> posts = mapper.readValue(
                    response.getEntity().getContent(),
                    new TypeReference<>() {
                    });

            posts.stream()
                    .filter(data -> data.getUpvotes() > 0)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
