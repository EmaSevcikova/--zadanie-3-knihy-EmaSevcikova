package sk.stuba.fei.uim.oop.assignment3.lendinglist.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BooksToLend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private LendingList lendingList;

    public BooksToLend(Book book, LendingList lendingList) {
        this.book = book;
        this.lendingList = lendingList;
    }
}
