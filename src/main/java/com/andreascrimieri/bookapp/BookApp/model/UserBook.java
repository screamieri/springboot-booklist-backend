package com.andreascrimieri.bookapp.BookApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name="UserBook")
public class UserBook {


    @EmbeddedId
    @JsonIgnore
    private UserBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JsonIgnore
    private Book book;

    @Column(name="added_on")
    private Date dateAdded = new Date();

    @Column(name="rating")
    private Integer rating;

    @Column(name="currentPage")
    private Integer currentPage;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="read_at")
    private Date readAt;

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getReadAt() {
        return readAt;
    }

    public void setReadAt(Date readAt) {
        this.readAt = readAt;
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

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                //", user=" + user +
                //", book=" + book +
                ", dateAdded=" + dateAdded +
                ", rating=" + rating +
                ", currentPage=" + currentPage +
                ", status=" + status +
                ", readAt=" + readAt +
                '}';
    }
}
