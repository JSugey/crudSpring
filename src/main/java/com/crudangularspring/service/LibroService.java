/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudangularspring.service;

import com.crudangularspring.model.Libro;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface LibroService {
//    Guardar libro
    int save(Libro libro);
//    obtener un libro
    Libro get(int id);
//    optener lista de libros
    List<Libro> list();
//    actualizar libro
    void update(int id, Libro libro);
//    eliminar libro
    void delete(int id);
}
