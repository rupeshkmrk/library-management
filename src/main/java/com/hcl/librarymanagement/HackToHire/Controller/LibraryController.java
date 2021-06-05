package com.hcl.librarymanagement.HackToHire.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.librarymanagement.HackToHire.Service.LibraryService;
import com.hcl.librarymanagement.HackToHire.exception.BookNotFound;

@RestController
public class LibraryController {

	@Autowired
	public LibraryService service;

	@GetMapping("/user/{username}/book/{bookName}")
	public String returnBook(@PathVariable String username, @PathVariable String bookName) throws BookNotFound {
		return service.returnBookOfAUser(username, bookName);
	}
}
