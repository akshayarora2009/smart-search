package Communication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jatin on 3/10/16.
 */
public class SendRequestSync {
    private final HttpPost request;
    CloseableHttpClient httpClient;

    public SendRequestSync(CloseableHttpClient httpClient, String data) throws UnsupportedEncodingException
    {
        request = new HttpPost("http://localhost/test.php");
        HttpEntity entity = new ByteArrayEntity(data.getBytes("UTF-8"));
        request.setEntity(entity);
        this.httpClient = httpClient;
    }

    public String executeRequest() throws IOException {
        HttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }
}
