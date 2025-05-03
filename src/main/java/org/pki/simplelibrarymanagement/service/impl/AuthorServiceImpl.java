package org.pki.simplelibrarymanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.dto.AuthorDTO;
import org.pki.simplelibrarymanagement.entities.Author;
import org.pki.simplelibrarymanagement.exception.AuthorOperationException;
import org.pki.simplelibrarymanagement.repository.AuthorRepository;
import org.pki.simplelibrarymanagement.service.AuthorService;
import org.pki.simplelibrarymanagement.util.MapperUtil;
import org.pki.simplelibrarymanagement.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final MapperUtil mapper;
    private final ValidationUtil validationUtil;

    @Override
    public AuthorDTO save(Author author) {
        try {
            if (!validationUtil.objectHasViolation(author)) {
                validationUtil.throwViolations(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public AuthorDTO update(Author author) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Author author) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findById(Long id) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findByEmail(String email) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public List<Author> findAll() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findByFirstNameAndLastName(String firstName, String lastName) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }
}
