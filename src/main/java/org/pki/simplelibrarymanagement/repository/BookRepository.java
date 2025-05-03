package org.pki.simplelibrarymanagement.repository;

import org.pki.simplelibrarymanagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Optional<Book> findByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b JOIN b.author a " +
            "WHERE LOWER(a.firstName) LIKE LOWER(CONCAT('%', :firstName, '%')) " +
            "AND LOWER(a.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))")
    List<Book> findByAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
