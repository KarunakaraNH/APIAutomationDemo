package resources;

public enum APIResource {
    addPlaceAPI("/maps/api/place/add/json"),
    deletePlaceAPI("/maps/api/place/delete/json"),
    getPlaceAPI("/maps/api/place/get/json");
    private String resource;

    APIResource(String resource) {
        this.resource=resource;
    }

    public String getAPIResource(){
        return resource;
    }
}
