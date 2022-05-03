package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;

import java.util.List;

public interface ILendingListService {

    List<LendingList> getAll();

    LendingList createList();
}
