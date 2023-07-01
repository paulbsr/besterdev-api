package ie.bester.besterdevapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ie.bester.besterdevapi.entity.EntityOne ;
import ie.bester.besterdevapi.repository.RepoOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")

public class ControllerOne {
    @Autowired
    private RepoOne repoOne;

    //RETURN HELLO WORLD:
    //PROD: https://besterdev-be-f61a2efc23c9.herokuapp.com/api/v1/hello
    @GetMapping("/hello")
    private String helloWorld() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd @ HH:mm");
        LocalDateTime now = LocalDateTime.now();
//        System.out.println(dtf.format(now));
        return "Hello World......" +now;}

    //RETURN ALL RECORDS:
    //PROD: https://besterdev-be-f61a2efc23c9.herokuapp.com/api/v1/records
    //LOCAL: http://localhost:8000/api/v1/records
    @GetMapping("/records")
    private List<EntityOne> getAllRecords() {return repoOne.findAll();}

    //CREATE NEW RECORD:
    //PROD: https://besterdev-be-f61a2efc23c9.herokuapp.com/api/v1/records/create
    //LOCAL: http://localhost:8000/api/v1/records/create
    //POST STRING: { "colone": "1", "coltwo": "2", "colthree": "3", "colfour": "4", "coldate": "2023-02-02"}
    @RequestMapping(value = "/records/create", method = RequestMethod.POST)
    EntityOne postRecord(@RequestBody EntityOne tableoneentity) {
        EntityOne newRecord = repoOne.save(tableoneentity);
        return newRecord;}

}
