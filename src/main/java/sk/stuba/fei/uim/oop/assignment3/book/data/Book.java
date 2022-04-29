package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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
}
