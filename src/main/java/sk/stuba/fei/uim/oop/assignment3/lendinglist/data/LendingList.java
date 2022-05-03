package sk.stuba.fei.uim.oop.assignment3.lendinglist.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class LendingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<BooksToLend> booksToLendList;

    private boolean lended;

    public LendingList(){
        this.booksToLendList = new ArrayList<>();
        this.lended = true;
    }


}
