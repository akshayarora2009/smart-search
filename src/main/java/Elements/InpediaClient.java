package Elements;


import Communication.InpediaCommunication;
import Utilities.HelperMethods;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NonNull;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.IOException;

/**
 * Created by jatin on 8/9/16.
 */

@Getter
public class InpediaClient {

    String apiKey;
	CloseableHttpAsyncClient httpClientAysnc;
	CloseableHttpClient httpClientSync;

public <T> Index<T> initiateIndex(@NonNull String name, @NonNull Class<T> indexClass)
{
	return new Index<T> (name,indexClass,this);
}



void sendRequestAsync(int requestId, JsonObject data, InpediaCommunication inpediaCommunication) throws IOException {
		data.addProperty("apiKey",apiKey);
	    HelperMethods.sendRequestToServerAsync(requestId,data,httpClientAysnc,inpediaCommunication);
}

String sendRequestSync(JsonObject data) throws IOException
{
	data.addProperty("apiKey",apiKey);
	return HelperMethods.sendRequestToServerSync(data,httpClientSync);
}

 void startHttpClientAysnc()
{
	httpClientAysnc.start();
}

public void closeClient()
{
	try {
		closeAsync();
		closeSync();
		}
	catch (Exception e)
		{

		}
}

private void closeAsync() throws IOException
{
    httpClientAysnc.close();
}
private void closeSync() throws IOException
{
	httpClientSync.close();
}

}
