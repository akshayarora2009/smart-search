package builders;

import Model.InpediaClient;


public class InpediaClientBuilder {
	private String applicationId;
	private String apiKey;
	
	
	public void InpediaClient(String applicationId,String apiKey) {
			this.applicationId = applicationId;
			this.apiKey = apiKey;
	}
	
	
	public Model.InpediaClient build(){
			// We will send request to our API, 
			//create a new object of our InpediaClient With different values.
		InpediaClient ip = new InpediaClient();
		ip.setApiKey(apiKey);
		ip.setApiKey(applicationId);
		return ip;

	}
	
	
	
}
