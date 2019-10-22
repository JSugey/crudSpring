/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudangularspring.service;

import com.crudangularspring.dao.LibroDAO;
import com.crudangularspring.model.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
@Transactional
public class LibroServiceImpl implements LibroService{
    
    private LibroDAO libroDAO;
    
    public LibroServiceImpl(){}
    
    @Autowired
    public LibroServiceImpl(LibroDAO libroDao){
        super();
        this.libroDAO = libroDao;
    }

    @Override
    public int save(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Libro get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Libro> list() {
        List<Libro> lista = new ArrayList<>();
        libroDAO.findAll().forEach(e -> lista.add(e));
        return lista;
    }

    @Override
    public void update(int id, Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
