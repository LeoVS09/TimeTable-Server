package edu.bonch.leovs09.db;

import edu.bonch.leovs09.controllers.MainRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ssm.api.Schedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by LeoVS09 on 04.09.2016.
 */

public class TimeTable {
    private static final Logger log = LoggerFactory.getLogger(TimeTable.class);

    private String groupLabel = "ИКПИ";
    private String groupId = "53";
    private ArrayList<Schedule> schedules;
    private ServiceData serviceData = new ServiceData();
    private int idFile = 0;
    public TimeTable(){

        schedules = new ArrayList<>();
        for(String url: serviceData.getUrls()) {
            try {
                schedules.add(new Schedule(new URL(url)));
                log.info("------->Right parse file with Schedule:" + url);
            } catch (Exception e) {
                log.error("Error when parsing: " +url, e);
            }
        }

    }


    public String getCurrentTableForGroup(String group,int numOfWeek) throws Exception{
        setGroup(group);
        Schedule schedule = schedules.get(idFile);
        try {
//            this.schedule = new Schedule("schedule.xls");
            log.info("------->TimeTable::newSchedule: " + schedule.toString());
        }catch (Exception e){
            log.info("------->TimeTable::newSchedule: " + e.toString());
        }
        try {
            String result = schedule.getWeekJSONData(groupLabel,groupId,numOfWeek);
            return result;
    }catch (Exception e){
            log.info("------->TimeTable::getJsonSchedule: " + e.toString());
            throw e;
            }
    }

    public ArrayList<String> getListOfGroups(){
        ArrayList<String> groups = new ArrayList<>();
        for(Schedule schedule: schedules){
            groups.addAll(schedule.getGroups());
        }
        return groups;
    }

    public DataClientTable getDataTableForGroup(String group){
        return new DataClientTable();
    }

    private void setGroup(String group){
        this.idFile = serviceData.getIdFile(group);
        int n = group.indexOf("-");
        this.groupLabel = group.substring(0,n);
        this.groupId = group.substring(n+1,group.length());
    }
}
