/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudangularspring.controller;

import com.crudangularspring.service.LibroService;
import com.crudangularspring.model.Libro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/libros")
public class LibroController {
    
    private LibroService libroService;
    
    public LibroController(){}
    
    @Autowired
    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Libro>> lista(){
        List<Libro> lista = libroService.list();
        return ResponseEntity.ok().body(lista);
    }
}
