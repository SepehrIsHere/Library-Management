package org.pki.simplelibrarymanagement.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.pki.simplelibrarymanagement.dto.AuthorDTO;
import org.pki.simplelibrarymanagement.dto.BookDTO;
import org.pki.simplelibrarymanagement.dto.DashboardDTO;
import org.pki.simplelibrarymanagement.dto.UserDTO;
import org.pki.simplelibrarymanagement.entities.Author;
import org.pki.simplelibrarymanagement.entities.Book;
import org.pki.simplelibrarymanagement.entities.Dashboard;
import org.pki.simplelibrarymanagement.entities.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public AuthorDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public Author convertToEntity(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }

    public BookDTO convertToDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book convertToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public DashboardDTO convertToDto(Dashboard dashboard) {
        return modelMapper.map(dashboard, DashboardDTO.class);
    }

    public Dashboard convertToEntity(DashboardDTO dashboardDTO) {
        return modelMapper.map(dashboardDTO, Dashboard.class);
    }
}
