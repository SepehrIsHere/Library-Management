package org.pki.simplelibrarymanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pki.simplelibrarymanagement.dto.UserDTO;
import org.pki.simplelibrarymanagement.entities.User;
import org.pki.simplelibrarymanagement.enums.Role;
import org.pki.simplelibrarymanagement.exception.UserNotFoundException;
import org.pki.simplelibrarymanagement.exception.UserOperationException;
import org.pki.simplelibrarymanagement.repository.UserRepository;
import org.pki.simplelibrarymanagement.service.UserService;
import org.pki.simplelibrarymanagement.util.MapperUtil;
import org.pki.simplelibrarymanagement.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final MapperUtil mapper;
    private final ValidationUtil validationUtil;
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public User update(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> findAll() {
        try {
            return userRepository.findAll().stream()
                    .map(mapper::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public List<UserDTO> findByRole(Role role) {
        try {
            List<User> users = userRepository.findByRole(role).orElseThrow(() -> new UserNotFoundException("users not found by role"));
            return users.stream().map(mapper::convertToDto).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO findByUsername(String username) {
        try {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
            return mapper.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO findByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
            return mapper.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO findByFirstNameAndLastName(String firstName, String lastName) {
        try {
            User user = userRepository.findByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new UserNotFoundException(firstName + " " + lastName));
            return mapper.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO login(String username, String password) {
        try {
            User user = userRepository.login(username, password).orElseThrow(() -> new UserNotFoundException("User not found"));
            return mapper.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO findByNationalId(String nationalId) {
        try {
            User user = userRepository.findByNationalId(nationalId).orElseThrow(() -> new UserNotFoundException("User not found"));
            return mapper.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        try {
            User user = User.builder()
                    .firstName(userDTO.getFirstName())
                    .lastName(userDTO.getLastName())
                    .email(userDTO.getEmail())
                    .username(userDTO.getEmail())
                    .password(userDTO.getPassword())
                    .nationalId(userDTO.getNationalId())
                    .birthDate(userDTO.getBirthDate())
                    .gender(userDTO.getGender())
                    .phoneNumber(userDTO.getPhoneNumber())
                    .build();

            if (validationUtil.objectHasViolation(user)) {
                validationUtil.throwViolations(user);
            }
            return mapper.convertToDto(userRepository.save(user));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }
}
