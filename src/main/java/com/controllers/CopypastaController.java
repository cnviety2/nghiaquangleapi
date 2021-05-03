package com.controllers;

import com.dtos.RequestObject;
import com.dtos.ResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "copypasta")
public class CopypastaController {
    private ObjectMapper mapper;
    private Map<String, Object> copypastaMap;
    private List<String> listCategory;

    @PostConstruct
    private void init() {
        mapper = new ObjectMapper();
        copypastaMap = new HashMap();
        listCategory = new ArrayList<>();
        File copypastaFile;
        try {
            copypastaFile = new File("src/main/java/com/controllers/copypasta.json");
            copypastaMap = mapper.readValue(copypastaFile, HashMap.class);

        } catch (IOException e) {
        }
        for (String key : copypastaMap.keySet()) {
            listCategory.add(key);
        }
    }

    @GetMapping("/test")
    public Object test() {
        return new ResponseEntity<Object>(copypastaMap, HttpStatus.OK);
    }

    @PostMapping("/get")
    public Object concu(@RequestBody RequestObject reqObj) {
        String category = reqObj.getContent();
        List<String> content = (List<String>) copypastaMap.get(category);
        ResponseObject respObj = new ResponseObject();
        respObj.setListContent(content);
        return new ResponseEntity<ResponseObject>(respObj, HttpStatus.OK);
    }

    @GetMapping("/get-all-category")
    public Object cac() {
        ResponseObject respObj = new ResponseObject();
        respObj.setListContent(listCategory);
        return new ResponseEntity<ResponseObject>(respObj, HttpStatus.OK);
    }


}
