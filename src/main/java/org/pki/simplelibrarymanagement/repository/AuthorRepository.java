package org.pki.simplelibrarymanagement.repository;

import org.pki.simplelibrarymanagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    Optional<Author> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT a FROM Author a WHERE a.email = :email")
    Optional<Author> findByEmail(@Param("email") String email);


}
