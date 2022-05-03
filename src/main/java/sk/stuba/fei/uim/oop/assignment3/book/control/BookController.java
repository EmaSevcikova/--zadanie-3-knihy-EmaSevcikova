package sk.stuba.fei.uim.oop.assignment3.book.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.*;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping()
    public List<BookResponse> getAllBooks(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public BookResponse addBook(@RequestBody BookRequest request){
        return new BookResponse(this.service.createBook(request));
    }

    @GetMapping(value = "/{id}")
    public BookResponse getBook(@PathVariable("id") Long bookId){
        return new BookResponse(this.service.getById(bookId));
    }

    @PutMapping(value = "/{id}")
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookUpdateRequest request){
        return new BookResponse(this.service.update(bookId,request));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long bookId){
        this.service.delete(bookId);
    }

    @GetMapping(value = "/{id}/amount")
    public BookAmountResponse getBookAmount(@PathVariable("id") Long bookId){
        return new BookAmountResponse(this.service.getById(bookId));
    }

    @PostMapping(value = "/{id}/amount")
    public BookAmountResponse increaseBookAmount(@PathVariable("id") Long bookId, @RequestBody IncreaseAmount request){
        return new BookAmountResponse(this.service.increaseAmount(bookId,request));
    }

    @GetMapping(value = "/{id}/lendCount")
    public LendCountResponse getBookLendCount(@PathVariable("id") Long bookId){
        return new LendCountResponse(this.service.getById(bookId));
    }

}
