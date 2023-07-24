package resources;

import pojo.AddPlace;
import pojo.LocationRequest;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayLoad(String name,String language,String address){
        AddPlace p=new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhoneNumber("9916730290");
        p.setWebsite("https://www.p.com");
        p.setName(name);
        List<String> mylist=new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        p.setTypes(mylist);
        LocationRequest loc=new LocationRequest();
        loc.setLat(33.222);
        loc.setLng(19922);
        p.setLocation(loc);
        return p;
    }

    public String deletePlacePayLoad(String placeid){
        return "{\n" + "    \"place_id\":\"" + placeid + "\"\n" + "}";

    }

    public String createUserPayload(String name, String job) {
        return "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}";
    }

}
