package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
}

