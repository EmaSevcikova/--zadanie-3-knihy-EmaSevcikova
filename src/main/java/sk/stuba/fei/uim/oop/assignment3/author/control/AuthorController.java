package sk.stuba.fei.uim.oop.assignment3.author.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.service.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.author.control.bodies.AuthorResponse;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IAuthorService service;

    @GetMapping()
    public List<AuthorResponse> getAllAuthors(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request){
        return new ResponseEntity<>(new AuthorResponse(this.service.createAuthor(request)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public AuthorResponse getAuthor(@PathVariable("id") Long authorId){
        return new AuthorResponse(this.service.getById(authorId));
    }

    @PutMapping(value = "/{id}")
    public AuthorResponse updateAuthor(@PathVariable("id") Long authorId, @RequestBody AuthorRequest request){
        return new AuthorResponse(this.service.update(authorId,request));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor(@PathVariable("id") Long authorId){
        this.service.delete(authorId);
    }
}

