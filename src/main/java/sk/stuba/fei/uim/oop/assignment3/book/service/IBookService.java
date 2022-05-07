package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.IncreaseAmount;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book createBook(BookRequest request) throws NotFoundException;

    Book getById(Long id) throws NotFoundException;

    Book update(Long id, BookUpdateRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Book increaseAmount(Long id, IncreaseAmount request) throws NotFoundException;
}
