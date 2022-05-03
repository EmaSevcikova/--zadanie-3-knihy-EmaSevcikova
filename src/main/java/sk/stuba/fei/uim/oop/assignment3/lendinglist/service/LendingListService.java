package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingListRepository;

import java.util.List;

@Service
public class LendingListService implements ILendingListService{

    @Autowired
    LendingListRepository repository;

    @Override
    public List<LendingList> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LendingList createList() {
        return this.repository.save(new LendingList());
    }
}
