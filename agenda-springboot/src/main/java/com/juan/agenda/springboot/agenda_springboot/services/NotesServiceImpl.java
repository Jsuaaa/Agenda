package com.juan.agenda.springboot.agenda_springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.agenda.springboot.agenda_springboot.entities.Notes;
import com.juan.agenda.springboot.agenda_springboot.repositories.NotesRepository;


@Service
public class NotesServiceImpl implements NotesService{

    @Autowired
    NotesRepository notesRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Notes> findById(Long id) {
        return notesRepository.findById(id);
    }

    @Override
    @Transactional
    public Notes save(Notes note) {
        return notesRepository.save(note);
    }

    @Override
    public Optional<Notes> update(Long id, Notes note) {
        Optional<Notes> noteOptionalFromDB = notesRepository.findById(id);

        if(noteOptionalFromDB.isPresent()){
            Notes noteFromDB = noteOptionalFromDB.get();
            noteFromDB.setName(note.getName());
            noteFromDB.setDescription(note.getDescription());
            noteFromDB.setActive(note.isActive());
            return Optional.of(notesRepository.save(noteFromDB));
        }
        return noteOptionalFromDB;
    }

    @Override
    public Optional<Notes> delete(Long id) {
        Optional<Notes> noteOptionalFromDB = notesRepository.findById(id);
        noteOptionalFromDB.ifPresent(noteDb -> notesRepository.delete(noteDb));
        return noteOptionalFromDB;
    }

}
