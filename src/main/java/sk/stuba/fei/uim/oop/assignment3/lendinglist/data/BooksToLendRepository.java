package sk.stuba.fei.uim.oop.assignment3.lendinglist.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksToLendRepository extends JpaRepository<BooksToLend, Long>{
    List<BooksToLend> findAll();

    BooksToLend findBooksToLendById(Long id);
}
