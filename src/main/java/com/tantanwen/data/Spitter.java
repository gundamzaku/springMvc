package com.tantanwen.data;

import com.sun.istack.internal.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dan on 2016/12/23.
 */
public class Spitter {

    private Long id;
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;


    @Size(min=2, max=30, message="{lastName.size}")
    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String email;
    //private MultipartFile profilePicture;
    public Spitter() {}

    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        System.out.println("test................"+firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*
    public MultipartFile getProfilePicture() {
        return this.profilePicture;
    }*/
    /*
    public void setProfilePicture(MultipartFile profilePicture) {

        System.out.println("test................"+profilePicture);
        this.profilePicture = profilePicture;
        System.out.println("test................"+profilePicture.getOriginalFilename());
    }*/
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password", "email");
    }

    public Spitter toSpitter() {
        return new Spitter(username, password, firstName, lastName, email);
    }
}
