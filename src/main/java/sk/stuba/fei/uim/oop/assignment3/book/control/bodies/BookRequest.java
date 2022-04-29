package sk.stuba.fei.uim.oop.assignment3.book.control.bodies;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookRequest {
    private String name;
    private String description;
    private Long author;
    private Long pages;
    private Long amount;
    private Long lendCount;
}
