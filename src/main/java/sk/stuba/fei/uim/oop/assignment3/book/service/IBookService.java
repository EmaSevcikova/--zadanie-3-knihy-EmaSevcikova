package sk.stuba.fei.uim.oop.assignment3.book.service;

import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book createBook(BookRequest request);
}
