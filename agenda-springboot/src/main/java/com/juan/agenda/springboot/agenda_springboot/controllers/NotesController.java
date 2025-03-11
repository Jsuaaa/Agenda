package com.juan.agenda.springboot.agenda_springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.agenda.springboot.agenda_springboot.entities.Notes;
import com.juan.agenda.springboot.agenda_springboot.services.NotesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesService notesService;

    @GetMapping
    public List<Notes> getAllNotes() {
        return notesService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable Long id){
        Optional<Notes> optionalNoteFromDb = notesService.findById(id);
        if(optionalNoteFromDb.isPresent()){
            return ResponseEntity.ok().body(optionalNoteFromDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Notes> createNote(@RequestBody Notes note) {
        return ResponseEntity.ok(notesService.save(note));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable Long id, @RequestBody Notes note) {
        Optional<Notes> optionalNoteFromDb = notesService.update(id, note);
        if(optionalNoteFromDb.isPresent()){
            ResponseEntity.ok(optionalNoteFromDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Notes> deleteNote(@PathVariable Long id){
        Optional<Notes> optionalNoteFromDb = notesService.delete(id);
        if(optionalNoteFromDb.isPresent()){
            return ResponseEntity.ok(optionalNoteFromDb.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
}
