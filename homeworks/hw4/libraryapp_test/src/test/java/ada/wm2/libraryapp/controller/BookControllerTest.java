package ada.wm2.libraryapp.controller;


import ada.wm2.libraryapp.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Mock
    BookService bookService;

    @Mock
    Map<String, Object> model;

    @InjectMocks
    BookController bookController;

    MockMvc mockMvc;



    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("Add page will return book_add page")
    void testAddPage() throws Exception {
        mockMvc.perform(get("/book/addBook"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(view().name("book_add"));
    }

    @Test
    @DisplayName("List all books and will return bookList page")
    void testGetAllBook() throws Exception{
        mockMvc.perform(get("/book/list"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("bookList"));

    }

    @Test
    @DisplayName("Save a book and  will return book_add page")
    void testSave() throws Exception{
        mockMvc.perform(post("/book/save"))
                .andExpect(status().isOk())
                .andExpect(view().name("book_add"));

    }

    @Test
    @DisplayName("Delete a book and  will return bookList page")
    void testDeleteBook() throws Exception{
        mockMvc.perform(get("/book/{pId}",anyInt()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"))
                .andExpect(view().name("bookList"));

    }

    @Test
    @DisplayName("Edit books and  will return bookList page")
    void testEditBook() throws Exception{
        mockMvc.perform(get("/book/edit/{pId}",anyInt()))
                .andExpect(status().isOk());
    }


}
