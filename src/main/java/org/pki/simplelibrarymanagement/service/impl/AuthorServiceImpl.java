package org.pki.simplelibrarymanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.dto.AuthorDTO;
import org.pki.simplelibrarymanagement.entities.Author;
import org.pki.simplelibrarymanagement.exception.AuthorNotFoundException;
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
            return mapper.convertToDto(authorRepository.save(author));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public AuthorDTO update(Author author) {
        try {
            return mapper.convertToDto(authorRepository.save(author));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(Author author) {
        try {
            authorRepository.delete(author);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            authorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findById(Long id) {
        try {
            return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author Not Found !"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findByEmail(String email) {
        try {
            return authorRepository.findByEmail(email).orElseThrow(() -> new AuthorNotFoundException("Author Not Found !"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public List<Author> findAll() {
        try {
            return authorRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public Author findByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return authorRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new AuthorNotFoundException("Author Not Found !"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        try {
            Author author = Author.builder()
                    .firstName(authorDTO.getFirstName())
                    .lastName(authorDTO.getLastName())
                    .email(authorDTO.getEmail())
                    .build();
            return save(author);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthorOperationException(e.getMessage());
        }
    }
}
