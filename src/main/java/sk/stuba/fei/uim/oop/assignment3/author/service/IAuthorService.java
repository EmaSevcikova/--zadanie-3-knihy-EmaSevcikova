package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();

    Author createAuthor(AuthorRequest request);

    Author getById(long id) throws NotFoundException;

    Author save(Author author);

    Author update(Long authorId, AuthorRequest request) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
}
