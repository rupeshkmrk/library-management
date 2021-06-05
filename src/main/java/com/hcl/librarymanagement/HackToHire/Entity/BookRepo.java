package com.hcl.librarymanagement.HackToHire.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRepo {
	@Id
	private int id;
	private String name;
	private String author_name;
	private String status;
	private int book_borrowed_id;
	private int rack_no;
	private int book_edition;
}
