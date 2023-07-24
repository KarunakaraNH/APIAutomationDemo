package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddPlaceResponse {

    private String status;
    //@JsonProperty("place_id")
    private String place_id;
    private String scope;
    private String reference;
    private String id;

}
