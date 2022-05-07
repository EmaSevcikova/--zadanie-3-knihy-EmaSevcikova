package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Long author;
    private Long pages;
    private Long amount;
    private Long lendCount;

    @ManyToOne
    private Author bookAuthor;


    public Book(BookRequest request){
        this.name = request.getName();
        this.description = request.getDescription();
        this.author = request.getAuthor();
        this.pages = request.getPages();
        this.amount = request.getAmount();
        this.lendCount = request.getLendCount();

    }
}
