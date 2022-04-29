package sk.stuba.fei.uim.oop.assignment3.book.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorResponse;
import sk.stuba.fei.uim.oop.assignment3.book.IBookService;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping()
    public List<BookResponse> getAllAuthors(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }
}
