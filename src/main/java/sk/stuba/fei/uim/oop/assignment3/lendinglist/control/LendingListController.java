package sk.stuba.fei.uim.oop.assignment3.lendinglist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.control.bodies.BookResponse;
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
    public LendingListResponse addList(){
        return new LendingListResponse(this.service.createList());
    }
}
