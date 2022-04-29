package sk.stuba.fei.uim.oop.assignment3.book.control.bodies;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

public class BookResponse {
    private long bookId;
    private String name;
    private String description;
    private long author;
    private long pages;
    private long amount;
    private long lendCount;

    public BookResponse(Book book){
        this.bookId = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.author = book.getAuthor();
        this.pages = book.getPages();
        this.amount = book.getAmount();
        this.lendCount = book.getLendCount();


    }
}
