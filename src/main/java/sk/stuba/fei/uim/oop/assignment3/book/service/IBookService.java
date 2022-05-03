package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.IncreaseAmount;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book createBook(BookRequest request);

    Book getById(long id);

    Book update(long id, BookUpdateRequest request);

    void delete(long id);

    Book increaseAmount(Long id, IncreaseAmount request);
}
