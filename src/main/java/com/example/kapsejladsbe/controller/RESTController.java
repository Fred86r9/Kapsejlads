package com.example.kapsejladsbe.controller;

import com.example.kapsejladsbe.model.Sailboat;
import com.example.kapsejladsbe.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {

    @Autowired
    SailboatRepository sailboatRepository;

    @GetMapping("/allboats")
    public List<Sailboat> getSailboat(){
        return sailboatRepository.findAll();
    }


}
