package com.hcl.librarymanagement.HackToHire.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.librarymanagement.HackToHire.BookRepository;
import com.hcl.librarymanagement.HackToHire.Entity.Books;

@Component("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	public List<Books> getAllBookDetailsByName(String bookName){
		List<Books> booksList=bookRepository.findByBookName(bookName);
		return booksList;
	}


	@Override
	public List<Books> getAllBookDetailsByMemberId(Integer memberId) {
		List<Books> booksList=bookRepository.findByUserId(memberId);
		
		return booksList;
	}


	@Override
	public Books addBook(Books book) {
		return bookRepository.saveAndFlush(book);
	}

}
