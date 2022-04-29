package sk.stuba.fei.uim.oop.assignment3.author.control.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

@Getter
public class AuthorResponse {

    private long id;
    private String name;
    private String surname;

    public AuthorResponse(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
    }
}
