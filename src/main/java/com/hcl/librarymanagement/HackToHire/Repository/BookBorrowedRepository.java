package com.hcl.librarymanagement.HackToHire.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.librarymanagement.HackToHire.Entity.BookBorrowed;

@Repository
public interface BookBorrowedRepository extends JpaRepository<BookBorrowed, Integer> {

}
