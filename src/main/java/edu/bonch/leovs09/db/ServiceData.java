package edu.bonch.leovs09.db;

import ssm.api.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LeoVS09 on 09.09.2016.
 */
public class ServiceData {
    private ArrayList<String> urls;
    private Map<String,Integer> groupToFile = new HashMap<>();

    public ServiceData() {
        urls = new ArrayList<>();
        urls.add("https://www.sut.ru/doci/stud/raspisanie/iks/2.xls");
        urls.add("https://www.sut.ru/doci/stud/raspisanie/rts/2.xls");

        groupToFile.put("ИКПИ-53",0);
        groupToFile.put("ИКПИ-52",0);
        groupToFile.put("PT-52",1);
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public int getIdFile(String group){
        return groupToFile.get(group);
    }
}
