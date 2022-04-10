package RawData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Tire {

    public LinkedHashMap<Double, Integer> getTireInformation() {
        return tireInformation;
    }

    private LinkedHashMap<Double,Integer> tireInformation = new LinkedHashMap<>();

    public boolean getLowPressureTires(){

        tireInformation.entrySet().removeIf(entry -> entry.getKey()>1);

        if(tireInformation.size()>0){
            return true;
        }
        return false;
    }

}
