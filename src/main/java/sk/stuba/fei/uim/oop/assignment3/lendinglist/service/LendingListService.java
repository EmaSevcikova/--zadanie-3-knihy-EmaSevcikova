package sk.stuba.fei.uim.oop.assignment3.lendinglist.service;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.service.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.control.LendingListResponse;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingListRepository;

import java.util.List;
import java.util.Objects;
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
    public LendingList getById(Long id) throws NotFoundException {
        LendingList list = this.repository.findLendingListById(id);
        if (list == null){
            throw new NotFoundException();
        }
        return list;

    }

    @Override
    public void delete(Long id) throws NotFoundException{
        LendingList list = this.getById(id);

        if (list.isLended()){
            for (Book b: list.getBooks()) {
                b.setLendCount(b.getLendCount()-1);
            }
        }

        this.repository.delete(list);
    }

    @Override
    public LendingList addBook(Long id, BookIdRequest request) throws NotFoundException, BadRequestException {

        LendingList list = this.getById(id);
        Book book = bookService.getById(request.getId());

        boolean canBeAdded = book.getLendCount() < book.getAmount();

        if (list.isLended() || !canBeAdded){
            throw new BadRequestException();
        }

        for (Book b : list.getBooks()) {
                if (Objects.equals(b.getId(), book.getId())){
                    throw new BadRequestException();
                }
            }

        list.getBooks().add(book);

        return this.repository.save(list);
    }

    @Override
    public void removeBook(Long id, BookIdRequest request) throws NotFoundException {
        LendingList list = this.getById(id);
        if (this.bookService.getById(request.getId()) != null){
            Book book = this.bookService.getById(request.getId());
            list.getBooks().remove(book);
        }
        this.repository.save(list);
    }

    @Override
    public void lendList(Long id) throws NotFoundException, BadRequestException {
        LendingList list = this.getById(id);
        boolean booksCanBeLanded = true;

        for (Book b : list.getBooks()) {
            if (b.getAmount() <= b.getLendCount()){
                booksCanBeLanded = false;
                break;
            }
        }
        if (!list.isLended() && booksCanBeLanded){
            for (Book b : list.getBooks()) {
                b.setLendCount(b.getLendCount()+1);
            }
            list.setLended(true);
        }
        else {
            throw new BadRequestException();
        }

        this.repository.save(list);
    }

}
