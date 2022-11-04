package com.example.Rick.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.Rick.controller.RickDTO;
import com.example.Rick.service.RickService;
import com.google.gson.Gson;

@Service
public class RickServiceImpl implements RickService {
        
    @Override //consumo de una api
    public RickDTO consultarRick(Integer id) throws IOException {
        URL url = new URL("https://rickandmortyapi.com/api/character/"+String.valueOf(id)+"?format=json");
        //URL url = new URL("https://rickandmortyapi.com/api/character/"+String.valueOf(id));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson g = new Gson();
            System.out.println(response.toString()); //para ver que llega de la api, tuvimos que agregarle format=json
            RickDTO rickApi = g.fromJson(response.toString(), RickDTO.class); // declaro la variable pokeapi de tipo objeto PokeApi
            return rickApi; 
        }
    return null;
    
}
}
