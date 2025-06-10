package com.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String studentId;
    private String name;
    private List<Book> borrowedBooks;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID and Name cannot be empty.");
        }
        this.studentId = studentId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: '" + name + "'";
    }
}