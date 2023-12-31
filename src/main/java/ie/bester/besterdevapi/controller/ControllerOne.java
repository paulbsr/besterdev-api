package ie.bester.besterdevapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
;
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
    //PROD: https://besterdev-api-13a0246c9cf2.herokuapp.com/api/v1/hello
    @GetMapping("/hello")
    private String helloWorld() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd @ HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return "Hello World......" +now;}


    //RETURN ALL RECORDS:
    //PROD: https://besterdev-api-13a0246c9cf2.herokuapp.com/api/v1/records
    //LOCAL: http://localhost:8000/api/v1/records
    @GetMapping("/records")
    private List<EntityOne> getAllRecords() {return repoOne.findAll();}


    //CREATE NEW RECORD (POST):
    //PROD: https://besterdev-api-13a0246c9cf2.herokuapp.com/api/v1/records/create
    //LOCAL: http://localhost:8000/api/v1/records/create
    //POST STRING: { "colone": "1", "coltwo": "2", "colthree": "3", "colfour": "4", "coldate": "2023-02-02"}
    @RequestMapping(value = "/records/create", method = RequestMethod.POST)
    EntityOne postRecord(@RequestBody EntityOne tableoneentity) {
        EntityOne newRecord = repoOne.save(tableoneentity);
        return newRecord;}


    //UPDATE RECORD BY ID (PUT):
    //PROD: https://besterdev-api-13a0246c9cf2.herokuapp.com/api/v1/records/update/{ID}
    //LOCAL: http://localhost:8000/api/v1/records/update/{ID}
    //PUT STRING: { "colone": "PUT", "coltwo": "PUT", "colthree": "PUT", "colfour": "PUT", "coldate": "2000-01-01"}
    @RequestMapping(value = "/records/update/{ID}", method = RequestMethod.PUT)
    ResponseEntity<EntityOne> update (@PathVariable int ID, @RequestBody EntityOne changes) {
        System.out.println("Update a Record by ID");
        Optional<EntityOne> optionalChange = repoOne.findById(ID);
            {EntityOne existingChange = optionalChange.get();
            existingChange.setcolone(changes.getcolone());
            existingChange.setcoltwo(changes.getcoltwo());
            existingChange.setcolthree(changes.getcolthree());
            existingChange.setcolfour(changes.getcolfour());
            existingChange.setcoldate(changes.getcoldate());
            EntityOne savedChange = repoOne.save(existingChange);
            return new ResponseEntity<EntityOne>(savedChange, HttpStatus.ACCEPTED);}
    }

    //DELETE RECORD BY ID:
    //PROD: https://besterdev-api-13a0246c9cf2.herokuapp.com/api/v1/records/delete/{ID}
    //LOCAL: http://localhost:8000/api/v1/records/delete/{ID}
    @RequestMapping(value = "/records/delete/{ID}", method = RequestMethod.DELETE)
    EntityOne deleteRecord(@PathVariable("ID") int ID) {
        Optional<EntityOne> optionalRecord = repoOne.findById(ID);
        EntityOne extractedRecord = optionalRecord.get();
        repoOne.delete(extractedRecord);
        return extractedRecord;}
    }

