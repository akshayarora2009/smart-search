package Model;


import com.sun.javafx.tk.Toolkit;
import com.sun.jmx.snmp.tasks.Task;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InpediaClient {

	private  String applicationId;
	private String apiKey;


<T> Index<T> initiateIndex(@NonNull String name, @NonNull Class<T> indexClass)
{
	return new Index<T> (name,indexClass,this);
}

void addObject(String indexName,String data)
{

}



}
