package sk.stuba.fei.uim.oop.assignment3.lendinglist.control;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LendingListResponse {

    private long id;
    private List<BookResponse> lendingList;
    private boolean lended;

    public LendingListResponse(LendingList list){
        this.id = list.getId();
        this.lended = list.isLended();
        this.lendingList = list.getBooks().stream().map(BookResponse::new).collect(Collectors.toList());
    }
}
