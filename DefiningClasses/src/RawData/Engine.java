package RawData;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Engine {

    private int engineSpeed;
    private int enginePower;
    private LinkedHashMap<Integer,Integer> engineInformation = new LinkedHashMap<>();

    public LinkedHashMap<Integer, Integer> getEngineInformation() {
        return engineInformation;
    }
    public boolean getPowerfulEngine(){
        engineInformation.entrySet().removeIf(entry -> entry.getValue()<250);

        if(engineInformation.size()>0){
            return true;
        }
        return false;
    }

}
