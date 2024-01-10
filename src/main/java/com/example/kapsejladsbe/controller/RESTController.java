package com.example.kapsejladsbe.controller;

import com.example.kapsejladsbe.model.Sailboat;
import com.example.kapsejladsbe.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RESTController {

    @Autowired
    SailboatRepository sailboatRepository;

    @GetMapping("/allboats")
    public List<Sailboat> getSailboat(){
        return sailboatRepository.findAll();
    }

    @PostMapping("/newsailboat")
    public ResponseEntity<Sailboat> postSailboat(@RequestBody Sailboat sailboat)
    {
        Sailboat savedSailboat = sailboatRepository.save(sailboat);
        if (savedSailboat == null)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
        {
            return new ResponseEntity<>(savedSailboat, HttpStatus.CREATED);
        }
    }

    @PutMapping("/sailboat/{id}")
    public ResponseEntity<Sailboat> putSailboat(@PathVariable int id, @RequestBody Sailboat sailboat)
    {
        Optional<Sailboat> orgSailboat = sailboatRepository.findById(id);
        if (orgSailboat.isPresent())
        {
            sailboat.setId(id); //to make sure a new object is NOT created
            sailboatRepository.save(sailboat);
            return new ResponseEntity<>(sailboat, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new Sailboat(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/sailboat/{id}")
    public ResponseEntity<String> deleteSailboat(@PathVariable int id)
    {
        Optional<Sailboat> orgSailboat = sailboatRepository.findById(id);
        if(orgSailboat.isPresent())
        {
            sailboatRepository.deleteById(id);
            return ResponseEntity.ok("Sailboat deleted");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sailboat not found");
        }
    }

}
