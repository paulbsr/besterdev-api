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

@RestController
@RequestMapping("/api/v1")

public class ControllerOne {
        @Autowired
    private RepoOne repoOne;

    @GetMapping("/hello")
    private String helloWorld()
    {
        return "Hello World";
    }

    //RETURN ALL TASKS
    //PROD: https://besterdev-api-gm-com.cpi.gm.com/api/v1/taskrecords
    //DEV: https://besterdev-api.apps.pcfepg3mi.gm.com/api/v1/taskrecords
    //LOCAL: http://localhost:8000/api/v1/records
    @GetMapping("/records")
    private List<EntityOne> getAllRecords() {return repoOne.findAll();}

    //CREATE A NEW TASK
    //PROD: https://besterdev-api-gm-com.cpi.gm.com/api/v1/taskrecords/create
    //DEV: https://besterdev-api.apps.pcfepg3mi.gm.com/api/v1/taskrecords/create
    //LOCAL: http://localhost:8000/api/v1/taskrecords/create
    //INSOMNIA POST STRING = { "colOne": "colOne", "colTwo": "colTwo", "colThree": "colThree"}
    @RequestMapping(value = "/records/create", method = RequestMethod.POST)
    EntityOne postRecord(@RequestBody EntityOne tableoneentity) {
        EntityOne newRecord = repoOne.save(tableoneentity);
        return newRecord;}

}
