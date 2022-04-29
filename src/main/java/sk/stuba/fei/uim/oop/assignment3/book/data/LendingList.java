package sk.stuba.fei.uim.oop.assignment3.book.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LendingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //list of books

    private boolean lent;
}
