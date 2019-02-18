package mc.springframework.spring5WebApp.Controllers;

import mc.springframework.spring5WebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooKController {
    private BookRepository bookRepository;

    public BooKController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
@RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
    return"books";
    }
}
