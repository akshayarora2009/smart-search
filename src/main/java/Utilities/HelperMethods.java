package Utilities;

import Communication.InpediaCommunication;
import Communication.SendRequestAysnc;
import Communication.SendRequestSync;
import Model.InpediaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jatin on 28/9/16.
 */

public class HelperMethods {

private static Gson gson = new GsonBuilder().create();

    public static String getJsonString(Object obj) {
        return gson.toJson(obj);
    }


    public static Object getObjectFromJson(String jsonString, Class toClass) {
        Object obj = gson.fromJson(jsonString, toClass);
        return obj;
    }
    public static void sendRequestToServerAsync(int requestId, JsonObject jsonObject,CloseableHttpAsyncClient httpclientAsync, InpediaCommunication inpediaCommunication) throws IOException
    {
        String data = HelperMethods.getJsonString(jsonObject);
        FutureCallback<HttpResponse> futureCallBack  = getFutureCallBack(requestId,inpediaCommunication);
        SendRequestAysnc sendRequest = new SendRequestAysnc(httpclientAsync,futureCallBack,data);
        sendRequest.executeRequest();
    }

    public static String sendRequestToServerSync(JsonObject jsonObject, CloseableHttpClient httpclientSync) throws IOException
    {
        String data = HelperMethods.getJsonString(jsonObject);
        SendRequestSync sendRequest = new SendRequestSync(httpclientSync,data);
        return sendRequest.executeRequest();
    }


    //TODO : for time being whatever response is coming is being sent to the client, which will be coded later
    private static FutureCallback<HttpResponse> getFutureCallBack(final int requestId, final InpediaCommunication inpediaCommunication)
    {
        final InpediaResponse inpediaResponse = new InpediaResponse();
        return new FutureCallback<HttpResponse>(){
            public void completed(HttpResponse httpResponse) {
                try{
                    inpediaResponse.setIsSuccess(true);
                    inpediaResponse.setErrorMessage(null);
                    inpediaResponse.setJsonResponse(EntityUtils.toString(httpResponse.getEntity()));
                    inpediaCommunication.onInpediaResponse(requestId, inpediaResponse);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void failed(Exception e) {
                inpediaResponse.setIsSuccess(false);
                inpediaResponse.setErrorMessage("Network error");
                inpediaResponse.setJsonResponse(null);
                inpediaCommunication.onInpediaResponse(requestId, inpediaResponse);
            }

            public void cancelled() {

                inpediaResponse.setIsSuccess(true);
                inpediaResponse.setErrorMessage("Request Cancelled");
                inpediaResponse.setJsonResponse(null);
                inpediaCommunication.onInpediaResponse(requestId, inpediaResponse);
            }
        };
    }
}
