package edu.bonch.leovs09.controllers;

/**
 * Created by LeoVS09 on 04.09.2016.
 */

import edu.bonch.leovs09.db.TimeTable;
import edu.bonch.leovs09.utils.JsonWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.net.URL;

@RestController
public class MainRest {
    private static final Logger log = LoggerFactory.getLogger(MainRest.class);


    private static TimeTable timeTable = new TimeTable();

    @Autowired
    JsonWrapper json;

    @RequestMapping("/")
    public String index() {
        return "LOL";
    }

    @RequestMapping(value = "/currentTimeTable/{group}/{numOfWeek}",method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentTimeTable(@RequestHeader HttpHeaders headers, @PathVariable String group, @PathVariable int numOfWeek){
        try {
            String response = json.toString(timeTable.getCurrentTableForGroup(group,numOfWeek));
            return ResponseEntity.ok(response);
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }

    @RequestMapping(value = "/ListOfGroups", method = RequestMethod.GET)
    public ResponseEntity<String> getListOfGroups(@RequestHeader HttpHeaders headers){
        try{
            String response = json.toString(timeTable.getListOfGroups());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }

    }

    @RequestMapping(value = "/DataTimeTable/{group}",method = RequestMethod.GET)
    public ResponseEntity<String> getDataTimeTable(@RequestHeader HttpHeaders headers, @PathVariable String group){
        try {
            String response = json.toString(timeTable.getDataTableForGroup(group));
            return ResponseEntity.ok(response);
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.toString());
        }
    }


}
