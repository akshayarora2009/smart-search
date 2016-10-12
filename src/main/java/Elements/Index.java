package Elements;

import Communication.InpediaCommunication;
import Model.ApiKey;
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


    public void addObjectAsync( int requestId,@NonNull T object, @NonNull String objectId, @NonNull InpediaCommunication inpediaCommunication) throws IOException {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(object));
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECT);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);

    }

    public void addObjectsAsync( int requestId,@NonNull List<T> objects, @NonNull List<String> objectIds, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(objects));
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.ADD_OBJECTS);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void deleteObjectAsync(int requestId, @NonNull String objectId, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECT);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void deleteObjectsAsync(int requestId, @NonNull List<String> objectIds, @NonNull InpediaCommunication inpediaCommunication) throws IOException
    {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_OBJECTS);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void getObjectAsync(int requestId, @NonNull String objectId, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectId",objectId);
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECT);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void getObjectsAsync(int requestId, @NonNull List<String> objectIds, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("objectIds",HelperMethods.getJsonString(objectIds));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.GET_OBJECTS);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }


    public void deleteIndexAsync(int requestId,  @NonNull InpediaCommunication inpediaCommunication) throws IOException{
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.DELETE_INDEX);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void  searchAsync(int requestId,@NonNull Query query, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data",HelperMethods.getJsonString(query));
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.SEARCH_OBJECT);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
    }

    public void clearAsync(int requestId, @NonNull InpediaCommunication inpediaCommunication) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("index",name);
        jsonObject.addProperty("method", Constants.RequestMethods.CLEAR_INDEX);
        client.sendRequestAsync(requestId,jsonObject,inpediaCommunication);
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

    public String deleteObjectsSync( @NonNull List<String> objectIds) throws IOException
    {
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

    public String  searchSync(@NonNull Query query) throws IOException {
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

    private Boolean deleteKey(@NonNull String key) {
        return false;
    }
    private List<ApiKey> lisyKeys()
    {
        return null;
    }
}







