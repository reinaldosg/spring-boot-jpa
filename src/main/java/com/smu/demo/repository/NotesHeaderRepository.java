package com.smu.demo.repository;

import com.smu.demo.model.NotesHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotesHeaderRepository extends JpaRepository<NotesHeader, Long> {
    List<NotesHeader> findByNameIgnoreCase(String name);

}
