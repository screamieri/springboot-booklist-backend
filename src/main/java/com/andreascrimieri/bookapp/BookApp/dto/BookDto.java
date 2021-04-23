package com.andreascrimieri.bookapp.BookApp.dto;

import com.andreascrimieri.bookapp.BookApp.model.UserBook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

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
    @JsonProperty("details")
    private Set<UserBook> users = new HashSet<>();

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Set<UserBook> getUsers() {
        return users;
    }

    public void setUsers(Set<UserBook> users) {
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
}
