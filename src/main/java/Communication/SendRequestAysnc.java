package Communication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by jatin on 1/10/16.
 */
public class SendRequestAysnc {

    private final HttpPost request;
    private FutureCallback<HttpResponse> futureCallback;
    CloseableHttpAsyncClient httpClient;

    public SendRequestAysnc(CloseableHttpAsyncClient httpClient, FutureCallback<HttpResponse> futureCallback, String data) throws UnsupportedEncodingException
    {
        this.futureCallback = futureCallback;
        request = new HttpPost("http://localhost/test.php");
        HttpEntity entity = new ByteArrayEntity(data.getBytes("UTF-8"));
        request.setEntity(entity);
        this.futureCallback = futureCallback;
        this.httpClient = httpClient;
    }

    public void executeRequest()
    {
        httpClient.execute(request,futureCallback);
    }

}
