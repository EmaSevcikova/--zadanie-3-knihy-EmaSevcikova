package sk.stuba.fei.uim.oop.assignment3.lendinglist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.service.ILendingListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    @Autowired
    private ILendingListService service;

    @GetMapping()
    public List<LendingListResponse> getAllLists(){
        return this.service.getAll().stream().map(LendingListResponse::new).collect(Collectors.toList());
    }
    @PostMapping()
    public ResponseEntity<LendingListResponse> addList(){
        return new ResponseEntity<>(new LendingListResponse(this.service.createList()), HttpStatus.CREATED);

    }
    @GetMapping(value = "/{id}")
    public LendingListResponse getList(@PathVariable("id") Long listId) throws NotFoundException{
        return new LendingListResponse(this.service.getById(listId));
    }
    @DeleteMapping(value = "/{id}")
    public void deleteList(@PathVariable("id") Long listId) throws NotFoundException{
        this.service.delete(listId);
    }

    @PostMapping(value = "/{id}/add")
    public LendingListResponse addBookToList(@PathVariable("id") Long listId, @RequestBody BookIdRequest request) throws NotFoundException, BadRequestException {
        return new LendingListResponse(this.service.addBook(listId,request));
    }
    @DeleteMapping(value = "/{id}/remove")
    public void removeBookFromList(@PathVariable("id") Long listId, @RequestBody BookIdRequest request) throws NotFoundException{
        this.service.removeBook(listId,request);
    }
    @GetMapping(value = "/{id}/lend")
    public void lendList(@PathVariable("id") Long listId) throws NotFoundException, BadRequestException {
        this.service.lendList(listId);
    }
}
