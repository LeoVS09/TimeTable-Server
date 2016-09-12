package edu.bonch.leovs09.utils;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by LeoVS09 on 04.09.2016.
 */
@Service
public class JsonWrapper {

    private static final ObjectMapper json = new ObjectMapper();

    public JsonWrapper(){}

    public <T> String  toString(T object){

        String text = "\"Unknown error\"";
        try{
            text = json.writeValueAsString(object);
            return text;
        }catch (Exception e){
            return text;
        }
    }

}
