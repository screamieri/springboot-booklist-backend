package com.andreascrimieri.bookapp.BookApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "uuid", nullable = false, updatable = false, unique = true)
    private String id;
    @Column(name="isbn", nullable=false)
    private String isbn;
    @Column(name="isbn13", nullable=false)
    private String isbn13;
    @Column(name="title", nullable=false)
    private String title;
    @Column(name = "author", nullable=false)
    private String author;
    @Column(name="publisher", nullable=false)
    private String publisher;
    @Column(name="genre", nullable=false)
    private String genre;
    @Column(name="description", nullable=false)
    @Lob
    private String description;
    @Column(name="publishDate", nullable=false)
    private LocalDate publishDate;
    @Column(name="imagePath", nullable=false)
    private String imageUrl;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Book() {
    }

    public Book(String isbn, String isbn13, String title, String author, String publisher, String genre, String description, LocalDate publishDate, Set<User> users, String imageUrl) {
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.publishDate = publishDate;
        this.users = users;
        this.imageUrl = imageUrl;
    }

    public Book(String id, String isbn, String isbn13, String title, String author, String publisher, String genre, String description, LocalDate publishDate, Set<User> users, String imageUrl) {
        this.id = id;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.publishDate = publishDate;
        this.users = users;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        users.add(user);
        user.getBooks().add(this);
    }

    public void removeUser(User user){
        users.remove(user);
        user.getBooks().remove(this);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn) &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher) &&
                publishDate.equals(book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, publisher, publishDate);
    }
}
