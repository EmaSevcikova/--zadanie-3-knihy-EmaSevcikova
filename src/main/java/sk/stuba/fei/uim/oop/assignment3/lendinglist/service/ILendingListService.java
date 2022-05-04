package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.control.LendingListResponse;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;

import java.util.List;

public interface ILendingListService {

    List<LendingList> getAll();

    LendingList createList();

    LendingList getById(Long id);

    void delete(Long id);

    LendingList addBook(Long id, BookIdRequest request);

    void removeBook(Long id, BookIdRequest request);

    void lendList(Long id);
}
