package org.pki.simplelibrarymanagement.repository;

import org.pki.simplelibrarymanagement.entities.User;
import org.pki.simplelibrarymanagement.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    Optional<User> login(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.role = :role")
    Optional<List<User>> findByRole(@Param("role") Role role);

    @Query("SELECT u FROM User u WHERE u.birthDate = :birthDate")
    Optional<List<User>> findByBirthDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    Optional<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")
    Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT u FROM User u WHERE u.nationalId = :nationalId")
    Optional<User> findByNationalId(@Param("nationalId") String nationalId);
}
