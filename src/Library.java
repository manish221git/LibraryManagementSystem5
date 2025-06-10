package com.library.service;

import com.library.model.Book;
import com.library.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private final List<Book> books;
    private final List<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (books.stream().anyMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.add(book);
    }

    public void addStudent(Student student) {
        if (students.stream().anyMatch(s -> s.getStudentId().equals(student.getStudentId()))) {
            throw new IllegalArgumentException("Student with this ID already exists.");
        }
        students.add(student);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
    }

    public Optional<Student> findStudentById(String studentId) {
        return students.stream().filter(s -> s.getStudentId().equals(studentId)).findFirst();
    }

    public void issueBook(String isbn, String studentId) {
        Book book = findBookByIsbn(isbn).orElseThrow(() -> new IllegalArgumentException("Book not found."));
        Student student = findStudentById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found."));

        if (book.isIssued()) {
            throw new IllegalStateException("Book is already issued.");
        }

        book.setIssued(true);
        student.borrowBook(book);
    }

    public void returnBook(String isbn) {
        Book book = findBookByIsbn(isbn).orElseThrow(() -> new IllegalArgumentException("Book not found."));

        if (!book.isIssued()) {
            throw new IllegalStateException("Book was not issued.");
        }

        students.stream()
                .filter(s -> s.getBorrowedBooks().contains(book))
                .findFirst()
                .ifPresent(student -> {
                    student.returnBook(book);
                    book.setIssued(false);
                });
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}