package com.smu.demo.controller;

import com.smu.demo.entity.request.AddNotesRequest;
import com.smu.demo.exceptions.SaveNotesError;
import com.smu.demo.model.NotesHeader;
import com.smu.demo.service.NotesService;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api/v1")
public class NotesController {

    private static final Logger logger = LoggerFactory.getLogger(NotesController.class);

    @Autowired
    private NotesService notesService;

    @GetMapping("/notes")
    @Async
    public CompletableFuture<ResponseEntity<?>> getAllNotes(){

        List<NotesHeader> headers = this.notesService.getHeaders();
        return CompletableFuture.completedFuture(new ResponseEntity<>(headers, HttpStatus.OK));
    }

    @PutMapping("/notes")
    @Async
    public CompletableFuture<ResponseEntity<?>> addNotes(
            @RequestBody @NotNull AddNotesRequest request
    ){
        try {
            this.notesService.saveNewNotes(request.getTitle(), request.getContent());
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK));
        }catch (SaveNotesError e) {
            logger.error(e.getMessage());
            return CompletableFuture.completedFuture(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
        } catch (Exception e) {
            return CompletableFuture.completedFuture(new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}
