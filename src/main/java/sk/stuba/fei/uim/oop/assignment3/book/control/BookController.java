package sk.stuba.fei.uim.oop.assignment3.book.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.*;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;


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
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(this.service.createBook(request)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public BookResponse getBook(@PathVariable("id") Long bookId) throws NotFoundException{
        return new BookResponse(this.service.getById(bookId));
    }

    @PutMapping(value = "/{id}")
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookUpdateRequest request) throws NotFoundException{
        return new BookResponse(this.service.update(bookId,request));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) throws NotFoundException{
        this.service.delete(bookId);
    }

    @GetMapping(value = "/{id}/amount")
    public BookAmountResponse getBookAmount(@PathVariable("id") Long bookId) throws NotFoundException{
        return new BookAmountResponse(this.service.getById(bookId));
    }

    @PostMapping(value = "/{id}/amount")
    public BookAmountResponse increaseBookAmount(@PathVariable("id") Long bookId, @RequestBody IncreaseAmount request) throws NotFoundException{
        return new BookAmountResponse(this.service.increaseAmount(bookId,request));
    }

    @GetMapping(value = "/{id}/lendCount")
    public LendCountResponse getBookLendCount(@PathVariable("id") Long bookId)throws NotFoundException{
        return new LendCountResponse(this.service.getById(bookId));
    }

}
