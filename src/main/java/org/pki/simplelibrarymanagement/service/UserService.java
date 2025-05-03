package org.pki.simplelibrarymanagement.service;

import org.pki.simplelibrarymanagement.dto.UserDTO;
import org.pki.simplelibrarymanagement.entities.User;
import org.pki.simplelibrarymanagement.enums.Role;

import java.util.List;

public interface UserService {
    User save(User user);

    User update(User user);

    void delete(User user);

    void deleteById(long id);

    List<UserDTO> findAll();

    List<UserDTO> findByRole(Role role);

    UserDTO findByUsername(String username);

    UserDTO findByEmail(String email);

    UserDTO findByFirstNameAndLastName(String firstName, String lastName);

    UserDTO login(String username, String password);

    UserDTO findByNationalId(String nationalId);

    UserDTO  createUser(UserDTO userDTO);
}
