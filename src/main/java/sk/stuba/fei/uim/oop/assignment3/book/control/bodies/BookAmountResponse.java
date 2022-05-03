package sk.stuba.fei.uim.oop.assignment3.book.control.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

@Setter
@Getter
public class BookAmountResponse {
    private long amount;

    public BookAmountResponse(Book book){
        this.amount = book.getAmount();
    }
}
