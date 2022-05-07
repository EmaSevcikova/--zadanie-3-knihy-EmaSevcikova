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
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

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
    public Book createBook(BookRequest request) throws NotFoundException {
        Book book = this.repository.save(new Book(request));
        Author author = this.authorService.getById(request.getAuthor());

        book.setBookAuthor(author);
        author.getBooks().add(book);

        this.authorService.save(author);

        return this.repository.save(book);
    }

    @Override
    public Book getById(Long id) throws NotFoundException{
            Book book = this.repository.findBookById(id);
            if (book == null) {
                throw new NotFoundException();
            }
            return book;
    }

    @Override
    public Book update(Long id, BookUpdateRequest request) throws NotFoundException{
        Book book = this.getById(id);

        if (request.getName() != null){
            book.setName(request.getName());
        }

        if (request.getDescription() != null){
            book.setDescription(request.getDescription());
        }

        if (request.getAuthor() != null && request.getAuthor() != 0){
            Author author = this.authorService.getById(book.getAuthor());
            if (!author.getBooks().isEmpty()) {
                author.getBooks().remove(book);
            }
            Author newAuthor = this.authorService.getById(request.getAuthor());
            newAuthor.getBooks().add(book);
            book.setAuthor(request.getAuthor());
        }

        if (request.getPages() != 0){
            book.setPages(request.getPages());
        }

        return this.repository.save(book);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Book book = this.getById(id);
        Author author = this.authorService.getById(book.getAuthor());
        author.getBooks().remove(book);
        this.repository.delete(book);
    }

    @Override
    public Book increaseAmount(Long id, IncreaseAmount request) throws NotFoundException{
        Book book = this.getById(id);
        book.setAmount(book.getAmount()+ request.getAmount());
        return this.repository.save(book);
    }

}
