package Elements;

import Communication.InpediaCommunication;
import Model.ApiKey;
import Model.AsyncRequest;
import Model.Query;
import Utilities.Constants;
import Utilities.HelperMethods;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.io.IOException;
import java.util.List;

/**
 * Created by jatin on 8/9/16.
 */


//All functions are given here but will call client Function as Client got the
@AllArgsConstructor
public class Index<T>
{
    private String name;
    private Class<T> indexClass;
    private InpediaClient client;
    public String getName() {
        return name;
    }
    public Class<T> getIndexClass() {
        return indexClass;
    }

    public void addObjectAsync(AsyncRequest request,@NonNull T object, @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(object));
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECT);
        client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void addObjectsAsync( AsyncRequest request,@NonNull List<T> objects, @NonNull List<String> objectIds) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(objects));
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECTS);
        client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void deleteObjectAsync(AsyncRequest request, @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECT);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void deleteObjectsAsync(AsyncRequest request, @NonNull List<String> objectIds) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECTS);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void getObjectAsync(AsyncRequest request, @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECT);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void getObjectsAsync(AsyncRequest request, @NonNull List<String> objectIds) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECTS);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void deleteIndexAsync(AsyncRequest request,  @NonNull InpediaCommunication inpediaCommunication) throws IOException{
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_INDEX);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void  searchAsync(AsyncRequest request,@NonNull Query query) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(query));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.SEARCH_OBJECT);
                client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }
    public void clearAsync(AsyncRequest request) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.CLEAR_INDEX);
        client.sendRequestAsync(request.requestId,jsonObject,request.inpediaCommunication);
    }

//---

    public String addObjectSync(@NonNull T object, @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(object));
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECT);
        return client.sendRequestSync(jsonObject);
    }
    public String addObjectsSync(@NonNull List<T> objects, @NonNull List<String> objectIds) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(objects));
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECTS);
        return client.sendRequestSync(jsonObject);
    }
    public String deleteObjectSync( @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECT);
        return client.sendRequestSync(jsonObject);
    }
    public String deleteObjectsSync( @NonNull List<String> objectIds) throws IOException{
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECTS);
        return client.sendRequestSync(jsonObject);
    }
    public String getObjectSync( @NonNull String objectId) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECT);
        return client.sendRequestSync(jsonObject);
    }
    public String getObjectsSync( @NonNull List<String> objectIds) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECTS);
        return  client.sendRequestSync(jsonObject);
    }
    public String deleteIndexSync() throws IOException{
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_INDEX);
        return  client.sendRequestSync(jsonObject);
    }
    public String searchSync(@NonNull Query query) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(query));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.SEARCH_OBJECT);
        return client.sendRequestSync(jsonObject);
    }
    public String clearSync() throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.CLEAR_INDEX);
        return client.sendRequestSync(jsonObject);
    }

  //----

    private Boolean deleteKey(@NonNull String key) {
        return false;
    }
    private List<ApiKey> lisyKeys()
    {
        return null;
    }
}







