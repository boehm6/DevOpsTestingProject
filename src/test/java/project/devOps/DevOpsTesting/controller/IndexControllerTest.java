package project.devOps.DevOpsTesting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.service.impl.BookServiceImpl;
import project.devOps.DevOpsTesting.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    IndexController controller;

    BookServiceImpl bookService;

    UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        bookService = mock(BookServiceImpl.class);
        userService = mock(UserServiceImpl.class);
        controller = new IndexController(bookService, userService);
    }

    @Test
    public void testHome() {
        IndexController controller = new IndexController(bookService, userService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookService.getAllBooks()).thenReturn(books);
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("home"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                    .andExpect(MockMvcResultMatchers.model().attribute("books", books));
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }

}