package Model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jatin on 1/10/16.
 */
@Getter
@Setter
public class InpediaResponse {
     Boolean isSuccess  = false;
     String errorMessage;
     String jsonResponse;
}
