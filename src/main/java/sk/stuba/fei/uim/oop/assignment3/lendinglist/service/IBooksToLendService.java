package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.BooksToLend;

import java.util.List;

public interface IBooksToLendService {
    List<BooksToLend> getAll();
}
