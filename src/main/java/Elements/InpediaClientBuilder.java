package Elements;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.HttpAsyncClients;

/**
 * Created by jatin on 8/9/16.
 */

public class InpediaClientBuilder {
	private String apiKey;

	public void InpediaClientBuilder(String apiKey)
	{
			this.apiKey = apiKey;
	}


	public InpediaClient build()
	{
		InpediaClient ip = new InpediaClient();
		ip.apiKey = apiKey;
		ip.httpClientAysnc = HttpAsyncClients.createDefault();
		ip.httpClientSync = HttpClients.createDefault();
		ip.startHttpClientAysnc();
		return ip;
	}
	
	
	
}
