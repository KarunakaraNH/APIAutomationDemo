package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(){
        AddPlace p=new AddPlace();
        p.setAccuracy(50);
        p.setAddress("jala, KB Circle,KA");
        p.setLanguage("Kannada");
        p.setPhoneNumber("9916730290");
        p.setWebsite("https://www.p.com");
        p.setName("Karuna");
        List<String> mylist=new ArrayList<String>();
        mylist.add("shoe park");
        mylist.add("shop");
        p.setTypes(mylist);
        Location loc=new Location();
        loc.setLat(33.222);
        loc.setLng(19922);
        p.setLocation(loc);
        return p;
    }
}
