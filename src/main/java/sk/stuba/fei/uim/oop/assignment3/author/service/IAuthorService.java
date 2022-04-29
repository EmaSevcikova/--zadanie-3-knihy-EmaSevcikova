package sk.stuba.fei.uim.oop.assignment3.author.service;

import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();

    Author createAuthor(AuthorRequest request);
}
