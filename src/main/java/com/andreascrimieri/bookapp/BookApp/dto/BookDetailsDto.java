package com.andreascrimieri.bookapp.BookApp.dto;

import com.andreascrimieri.bookapp.BookApp.model.Status;
import com.andreascrimieri.bookapp.BookApp.model.UserBook;

import java.util.Date;

public class BookDetailsDto {
    private Date dateAdded;
    private Integer rating;
    private Integer currentPage;
    private Status status;
    private Date readAt;

    public BookDetailsDto() {
    }

    public BookDetailsDto(UserBook userBook) {
        this.dateAdded = userBook.getDateAdded();
        this.rating = userBook.getRating();
        this.currentPage = userBook.getCurrentPage();
        this.status = userBook.getStatus();
        this.readAt = userBook.getReadAt();
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
}
