package sk.stuba.fei.uim.oop.assignment3.book.control.bodies;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookUpdateRequest {
    private String name;
    private String description;
    private Long author;
    private Long pages;
}
