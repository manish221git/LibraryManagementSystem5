package com.library.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String isbn, String title, String author) {
        if (isbn == null || isbn.trim().isEmpty() || title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN and Title cannot be empty.");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: '" + title + "', Author: '" + author + "', Issued: " + isIssued;
    }
}