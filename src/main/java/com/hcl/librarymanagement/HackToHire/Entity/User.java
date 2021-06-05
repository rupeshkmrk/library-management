package com.hcl.librarymanagement.HackToHire.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    private UUID id;

    private String name;

    private String password;

    private String role;

}
