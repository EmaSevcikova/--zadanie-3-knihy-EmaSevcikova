package sk.stuba.fei.uim.oop.assignment3.book.control.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

@Getter
public class BookResponse {
    private long id;
    private String name;
    private String description;
    private long author;
    private long pages;
    private long amount;
    private long lendCount;

    public BookResponse(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.author = book.getAuthor();
        this.pages = book.getPages();
        this.amount = book.getAmount();
        this.lendCount = book.getLendCount();


    }
}
