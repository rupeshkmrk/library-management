/**
 * 
 */
package com.hcl.librarymanagement.HackToHire.Service;

import java.util.List;

import com.hcl.librarymanagement.HackToHire.Entity.Books;

/**
 * @author megha
 *
 */
public interface AdminService {

	 List<Books> getAllBookDetailsByName(String bookName);

	 List<Books> getAllBookDetailsByMemberId(Integer memberId);

	 Books addBook(Books book);
}
