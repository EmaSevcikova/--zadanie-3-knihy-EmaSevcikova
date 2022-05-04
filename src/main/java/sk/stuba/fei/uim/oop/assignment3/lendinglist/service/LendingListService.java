package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.control.LendingListResponse;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LendingListService implements ILendingListService{

    @Autowired
    LendingListRepository repository;

    @Autowired
    IBookService bookService;

    @Override
    public List<LendingList> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LendingList createList() {
        return this.repository.save(new LendingList());
    }

    @Override
    public LendingList getById(Long id) {
        LendingList list = this.repository.findLendingListById(id);
        //exception
        return list;

    }

    @Override
    public void delete(Long id) {
        this.repository.delete(this.getById(id));
        //decrement book lend count
    }

    @Override
    public LendingList addBook(Long id, BookIdRequest request) {
            LendingList list = this.repository.findLendingListById(id);
            if (this.bookService.getById(request.getId()) != null){
                Book book = this.bookService.getById(request.getId());
                list.getBooks().add(book);
            }

        return this.repository.save(list);
    }

    @Override
    public void removeBook(Long id, BookIdRequest request) {
        LendingList list = this.repository.findLendingListById(id);
        if (this.bookService.getById(request.getId()) != null){
            Book book = this.bookService.getById(request.getId());
            list.getBooks().remove(book);
        }
        this.repository.save(list);
    }

    @Override
    public void lendList(Long id) {
        LendingList list = this.repository.findLendingListById(id);
        if (!list.isLended()){
            list.setLended(true);
        }
        this.repository.save(list);
    }

}
