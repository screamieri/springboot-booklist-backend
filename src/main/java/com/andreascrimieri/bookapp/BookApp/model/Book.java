package com.andreascrimieri.bookapp.BookApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
    private Date publishDate;

    @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
    })
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, String genre, String description, Date publishDate, Set<User> users) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.publishDate = publishDate;
        this.users = users;
    }

    public Book(String id, String isbn, String title, String author, String publisher, String genre, String description, Date publishDate, Set<User> users) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.description = description;
        this.publishDate = publishDate;
        this.users = users;
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
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
}
