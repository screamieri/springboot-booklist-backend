package com.andreascrimieri.bookapp.BookApp.dto;

import com.andreascrimieri.bookapp.BookApp.model.UserBook;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {

    private String id;
    private String isbn;
    private String isbn13;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private String publishDate;
    private String imageUrl;
    private Integer pageCount;
    private String description;
    @JsonProperty("details")
    private BookDetailsDto bookDetails;

    public BookDetailsDto getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(UserBook userBook) {
        this.bookDetails = new BookDetailsDto(userBook);
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
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

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
