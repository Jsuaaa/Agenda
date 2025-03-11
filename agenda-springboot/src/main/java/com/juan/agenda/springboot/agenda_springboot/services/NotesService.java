package com.juan.agenda.springboot.agenda_springboot.services;

import java.util.List;
import java.util.Optional;

import com.juan.agenda.springboot.agenda_springboot.entities.Notes;

public interface NotesService {

    List<Notes> findAll();

    Optional<Notes> findById(Long id);

    Notes save(Notes note);

    Optional<Notes> update(Long id, Notes note);

    Optional<Notes> delete(Long id);

}
