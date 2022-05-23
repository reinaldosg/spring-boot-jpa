package com.smu.demo.service.impl;

import com.smu.demo.model.NotesDetail;
import com.smu.demo.model.NotesHeader;
import com.smu.demo.repository.NotesHeaderRepository;
import com.smu.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesHeaderRepository headerRepository;

    @Override
    public NotesHeader getHeaderById(Long id) {
        return this.headerRepository.findById(id).orElse(null);
    }

    @Override
    public List<NotesHeader> getHeaders() {
        return this.headerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveNewNotes(String title, String content) {
        NotesDetail detail = new NotesDetail();
        detail.setContent(content);

        NotesHeader header = new NotesHeader();
        header.setName(title);
        header.setDetail(detail);

        this.headerRepository.save(header);

    }
}
