package com.hcl.librarymanagement.HackToHire.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.librarymanagement.HackToHire.Entity.BookBorrowed;
import com.hcl.librarymanagement.HackToHire.Entity.BookRepo;
import com.hcl.librarymanagement.HackToHire.Entity.User;
import com.hcl.librarymanagement.HackToHire.Repository.BookBorrowedRepository;
import com.hcl.librarymanagement.HackToHire.Repository.BookRepository;
import com.hcl.librarymanagement.HackToHire.Repository.UserRepository;
import com.hcl.librarymanagement.HackToHire.exception.BookNotFound;

@Service
public class LibraryService {

	@Autowired
	public BookRepository bookRepo;

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public BookBorrowedRepository bookBorrowedRepo;

	public String returnBookOfAUser(String username, String bookName) throws BookNotFound {
		long excededNoDays = 0l;
		long fine = 0;
		BookRepo bookDetails = bookRepo.getByName(bookName);
		BookBorrowed book = bookBorrowedRepo.getById(bookDetails.getId());
		if (book == null)
			throw new BookNotFound("BookNotIssued");
		else {
			bookDetails.setStatus("AVAILABLE");
			bookRepo.save(bookDetails); // Saving the Status

			excededNoDays = getDifferenceDays(book.getDue_date(), java.util.Calendar.getInstance().getTime());
			if (excededNoDays <= 3)
				fine = excededNoDays * 20;
			else
				fine = excededNoDays * 50;
		}
		return "Your Book:" + bookDetails.getName() + " has been Sucessfully returned, You have Rs " + fine + " as Due";
	}

	public long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}
