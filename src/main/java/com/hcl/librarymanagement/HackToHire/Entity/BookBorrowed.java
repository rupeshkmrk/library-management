package com.hcl.librarymanagement.HackToHire.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowed {
	@Id
	int book_id;
	String user_id;
	Date Sbook_issue_Date;
	Date due_date;
}
