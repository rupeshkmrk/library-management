package com.hcl.librarymanagement.HackToHire;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.librarymanagement.HackToHire.Entity.Books;

/**
 * @author megha
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

	public List<Books> findByBookName(String name);

	public List<Books> findByUserId(Integer memberId);

}
