package com.hcl.librarymanagement.HackToHire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.librarymanagement.HackToHire.Entity.Books;
import com.hcl.librarymanagement.HackToHire.Service.AdminService;

/**
 * @author megha
 *
 */
@RestController
@RequestMapping("/admin")

public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(value="/getAllBookDetailsByName/{name}")
	public List<Books> getAllBookDetailsByName(@PathVariable(value="name", required=true) String bookName){
		
		return adminService.getAllBookDetailsByName(bookName);
		
	}
	
	@GetMapping("/getAllBookDetailsByMember/{id}")
	public List<Books> getAllBookDetailsByMemberId(@PathVariable("id") Integer memberId){
		
		return adminService.getAllBookDetailsByMemberId(memberId);
		
	}
	
	@PostMapping(value="/addBook")
	public Books addBook(@RequestBody Books book){
	
		return adminService.addBook(book);
		
	}
	
	

}
