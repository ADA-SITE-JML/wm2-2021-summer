/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emil.websummer2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emil
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepo repo;
	
    public List<BookService> listAll() {
        return repo.findAll();
    }
     
    public void save(BookService std) {
        repo.save(std);
    }
     
    public BookService get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
 
    
}
