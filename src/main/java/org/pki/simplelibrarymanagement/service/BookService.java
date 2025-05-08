package org.pki.simplelibrarymanagement.service;

import org.pki.simplelibrarymanagement.dto.BookDTO;
import org.pki.simplelibrarymanagement.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDTO save(Book book);

    BookDTO update(Book book);

    void delete(Book book);

    void deleteById(long id);

    BookDTO findByTitle(String title);

    List<Book> findAll();

    Optional<List<Book>> findByAuthor(String firstName, String lastName);

}
