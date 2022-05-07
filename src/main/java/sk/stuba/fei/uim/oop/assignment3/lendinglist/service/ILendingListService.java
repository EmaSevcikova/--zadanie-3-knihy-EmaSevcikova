package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.control.LendingListResponse;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;

import java.util.List;

public interface ILendingListService {

    List<LendingList> getAll();

    LendingList createList();

    LendingList getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    LendingList addBook(Long id, BookIdRequest request) throws NotFoundException, BadRequestException;

    void removeBook(Long id, BookIdRequest request) throws NotFoundException;

    void lendList(Long id) throws NotFoundException, BadRequestException;
}
