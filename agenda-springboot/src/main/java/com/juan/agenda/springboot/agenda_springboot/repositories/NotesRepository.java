package com.juan.agenda.springboot.agenda_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juan.agenda.springboot.agenda_springboot.entities.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long>{

}
