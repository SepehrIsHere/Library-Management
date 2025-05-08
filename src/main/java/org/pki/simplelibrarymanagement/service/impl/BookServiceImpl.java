package org.pki.simplelibrarymanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.dto.BookDTO;
import org.pki.simplelibrarymanagement.entities.Book;
import org.pki.simplelibrarymanagement.exception.BookNotFoundException;
import org.pki.simplelibrarymanagement.exception.BookOperationException;
import org.pki.simplelibrarymanagement.repository.BookRepository;
import org.pki.simplelibrarymanagement.service.BookService;
import org.pki.simplelibrarymanagement.util.MapperUtil;
import org.pki.simplelibrarymanagement.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final MapperUtil mapper;
    private final ValidationUtil validationUtil;

    @Override
    public BookDTO save(Book book) {
        try {
            if (validationUtil.objectHasViolation(book)) {
                validationUtil.throwViolations(book);
            }
            return mapper.convertToDto(bookRepository.save(book));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BookOperationException("");
        }
    }

    @Override
    public BookDTO update(Book book) {
        try {
            return mapper.convertToDto(bookRepository.save(book));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BookOperationException("");
        }
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO findByTitle(String title) {
        try {
            return mapper.convertToDto(bookRepository.findByTitle(title).orElseThrow(() -> new BookNotFoundException(title)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BookOperationException("");
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BookOperationException("");
        }
    }

    @Override
    public Optional<List<Book>> findByAuthor(String firstName, String lastName) {
        try {
            return Optional.ofNullable(Optional.ofNullable(bookRepository.findByAuthor(firstName, lastName)).orElseThrow(() -> new BookNotFoundException(firstName + " " + lastName + " " + " Not found")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BookOperationException("");
        }
    }
}
