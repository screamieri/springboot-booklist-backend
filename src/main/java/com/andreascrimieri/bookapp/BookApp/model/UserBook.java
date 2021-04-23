package com.andreascrimieri.bookapp.BookApp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name="UserBook")
public class UserBook {


    @EmbeddedId
    private UserBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @Column(name="added_on")
    private Date dateAdded = new Date();

    public UserBook() {
    }

    public UserBook(User user, Book book) {
        this.user = user;
        this.book = book;
        this.id = new UserBookId(user.getId(), book.getId());
    }

    public UserBookId getId() {
        return id;
    }

    public void setId(UserBookId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBook)) return false;
        UserBook userBook = (UserBook) o;
        return user.equals(userBook.user) &&
                book.equals(userBook.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);
    }
}
