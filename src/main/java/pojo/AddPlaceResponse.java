package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPlaceResponse {

    private String status;
    @JsonProperty("place_id")
    private String place_id;
    private String scope;
    private String reference;
    private String id;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaceId() {
        return place_id;
    }

    public void setPlaceId(String place_id) {
        this.place_id= place_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
