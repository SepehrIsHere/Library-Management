package org.pki.simplelibrarymanagement.service;

import org.pki.simplelibrarymanagement.dto.AuthorDTO;
import org.pki.simplelibrarymanagement.entities.Author;

import java.util.List;

public interface AuthorService {
    AuthorDTO save(Author author);

    AuthorDTO update(Author author);

    void delete(Author author);

    void deleteById(Long id);

    Author findById(Long id);

    Author findByEmail(String email);

    List<Author> findAll();

    Author findByFirstNameAndLastName(String firstName, String lastName);

    AuthorDTO createAuthor(AuthorDTO authorDTO);
}
