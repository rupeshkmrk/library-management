package com.hcl.librarymanagement.HackToHire.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.librarymanagement.HackToHire.Entity.BookRepo;

@Repository
public interface BookRepository extends JpaRepository<BookRepo, Integer> {
	BookRepo getByName(String bookName);
}
