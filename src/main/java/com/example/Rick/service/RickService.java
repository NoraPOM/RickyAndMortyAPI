package com.example.Rick.service;

import java.io.IOException;

import com.example.Rick.controller.RickDTO;

public interface RickService {
    public RickDTO consultarRick(Integer id) throws IOException;
}
