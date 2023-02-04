package com.example.springrecipe.repositories;

import com.example.springrecipe.domain.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
