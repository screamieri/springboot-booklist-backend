package com.andreascrimieri.bookapp.BookApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uuid", nullable = false, updatable = false, unique = true)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.books = books;
    }

    public User(String id, String firstName, String lastName, String email, String password, Set<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
        book.getUsers().add(this);
    }

    public void removeBook(Book book){
        books.remove(book);
        book.getUsers().remove(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
