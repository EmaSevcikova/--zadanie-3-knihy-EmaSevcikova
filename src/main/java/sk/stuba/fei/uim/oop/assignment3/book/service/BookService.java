package sk.stuba.fei.uim.oop.assignment3.book.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.IncreaseAmount;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private IAuthorService authorService;

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book createBook(BookRequest request) {
        Book book = this.repository.save(new Book(request));
        Author author = this.authorService.getById(request.getAuthor());

        book.setBookAuthor(author);
        author.getBooks().add(book);

        this.authorService.save(author);

        return this.repository.save(book);
    }

    @Override
    public Book getById(long id) {
            Book book = this.repository.findBookById(id);
//            if (book == null) {
//                throw new NotFoundException();
//            }
            return book;
    }

    @Override
    public Book update(long id, BookUpdateRequest request) {
        Book book = this.getById(id);

        if (request.getName() != null){
            book.setName(request.getName());
        }

        if (request.getDescription() != null){
            book.setDescription(request.getDescription());
        }

        if (request.getAuthor() != null){
            book.setAuthor(request.getAuthor());
        }

        if (request.getPages() != null){
            book.setPages(request.getPages());
        }

        return this.repository.save(book);
    }

    @Override
    public void delete(long id) {
        this.repository.delete(this.getById(id));
    }

    @Override
    public Book increaseAmount(Long id, IncreaseAmount request) {
        Book book = this.getById(id);
        book.setAmount(book.getAmount()+ request.getAmount());
        return this.repository.save(book);
    }

}
