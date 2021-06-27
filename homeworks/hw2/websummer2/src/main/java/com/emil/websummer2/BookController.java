/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.emil.websummer2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author emil
 */
@Controller
public class BookController {
    @Autowired
    private BookService service;
    
    //Listing all books in the home page
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<BookService> listbook = service.listAll();
        model.addAttribute("listbook", listbook);
        System.out.print("Get / ");	
        return "index";
    }

    //adding new book to our library
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("book", new BookService());
        return "new";
    }

    //when we hit save button post request calling and our book posted to the database
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") BookService std) {
        service.save(std);
        return "redirect:/";
    }
    
    //Editing book name by id it. EVERY BOOK HAS ITS OWN UNIQUE ID
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        BookService std = service.get(id);
        mav.addObject("book", std);
        return mav;

    }
    
    //We delete book by id too
    @RequestMapping("/delete/{id}")
    public String deletebook(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
    
}
