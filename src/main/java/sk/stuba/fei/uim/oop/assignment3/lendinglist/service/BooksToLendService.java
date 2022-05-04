package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.BooksToLend;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.BooksToLendRepository;

import javax.persistence.Access;
import java.util.List;

@Service
public class BooksToLendService implements IBooksToLendService{

    @Autowired
    private BooksToLendRepository repository;


    @Override
    public List<BooksToLend> getAll() {
        return this.repository.findAll();
    }
}
