package com.smu.demo.service;

import com.smu.demo.exceptions.SaveNotesError;
import com.smu.demo.model.NotesHeader;

import java.util.List;

public interface NotesService {
    NotesHeader getHeaderById(Long id);
    List<NotesHeader> getHeaders();

    void saveNewNotes(String title, String content) throws SaveNotesError;
}
