package sk.stuba.fei.uim.oop.assignment3.lendinglist.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.lendinglist.data.LendingList;

import java.util.List;

@Repository
public interface LendingListRepository extends JpaRepository<LendingList, Long> {
    List<LendingList> findAll();
}
