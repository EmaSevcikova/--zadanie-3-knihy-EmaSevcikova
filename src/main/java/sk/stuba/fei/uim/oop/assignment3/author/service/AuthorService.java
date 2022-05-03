package sk.stuba.fei.uim.oop.assignment3.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author createAuthor(AuthorRequest request) {
        return this.repository.save(new Author(request));
    }

    @Override
    public Author getById(long id) {
        Author author = this.repository.findAuthorById(id);
//            if (book == null) {
//                throw new NotFoundException();
//            }
        return author;
    }

    @Override
    public Author save(Author author) {
        return this.repository.save(author);
    }

    @Override
    public Author update(Long id, AuthorRequest request) {
        Author author = this.getById(id);

        if (request.getName() != null){
            author.setName(request.getName());
        }

        if (request.getSurname() != null){
            author.setSurname(request.getSurname());
        }

        return this.repository.save(author);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(this.getById(id));
    }
}
