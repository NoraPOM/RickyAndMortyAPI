package com.example.Rick.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rick.service.RickService;

@RestController
@RequestMapping( "/rick" )
public class RickController {
    private final RickService rickservice;
    public RickController( @Autowired RickService rickservice )
    {
        this.rickservice = rickservice;
    } 
    @GetMapping( "/{id}")
    public ResponseEntity<RickDTO> mostrarPeople(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(rickservice.consultarRick(id));
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
        
    }
}
