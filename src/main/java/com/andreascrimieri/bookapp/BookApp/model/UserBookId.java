package com.andreascrimieri.bookapp.BookApp.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserBookId implements Serializable {

    @Id
    @Column(name="id",updatable=false,nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long associationId;

    @Column(name="user_id")
    private String userId;
    @Column(name="book_id")
    private String bookId;

    public UserBookId() {
    }

    public UserBookId(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(long associationId) {
        this.associationId = associationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBookId)) return false;
        UserBookId that = (UserBookId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }
}
