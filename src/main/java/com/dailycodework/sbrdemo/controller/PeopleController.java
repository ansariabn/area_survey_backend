package com.dailycodework.sbrdemo.controller;

import com.dailycodework.sbrdemo.model.Peoples;

import com.dailycodework.sbrdemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000") //allowing client application to consume the backed
@RestController
@RequestMapping("/peoples")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    
	@GetMapping
    public ResponseEntity<List<Peoples>> getStudents(){
        return new ResponseEntity<>(peopleService.getPeople(), HttpStatus.FOUND);
    }
    @PostMapping
    public Peoples addStudent(@RequestBody Peoples peoples){
        return peopleService.addPeople(peoples);
    }
    @PutMapping("/update/{id}")
    public Peoples updateStudent(@RequestBody Peoples peoples, @PathVariable Long id){
        return peopleService.updatePeople(peoples, id);
    }
    @DeleteMapping("/delete/{id}")

    public void deleteStudent(@PathVariable Long id){
        peopleService.deletePeople(id);
    }
    @GetMapping("/people/{id}")
    public Peoples getPeopleById(@PathVariable Long id){
        return peopleService.getPeopleById(id);
    }


}
