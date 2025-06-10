package com.library.ui;

import com.library.model.Book;
import com.library.model.Student;
import com.library.service.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LibraryGUI extends JFrame {
    private final Library library;
    private final JTextArea displayArea;

    public LibraryGUI() {
        this.library = new Library();
        setTitle("📚 Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mainPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Controls Panel
        JPanel controlPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        mainPanel.add(controlPanel, BorderLayout.EAST);

        // Add Buttons to Control Panel
        controlPanel.add(createButton("Add Book", this::addBook));
        controlPanel.add(createButton("Add Student", this::addStudent));
        controlPanel.add(createButton("Issue Book", this::issueBook));
        controlPanel.add(createButton("Return Book", this::returnBook));
        controlPanel.add(createButton("List Books", e -> updateDisplay()));
        controlPanel.add(createButton("List Students", e -> updateStudentDisplay()));

        add(mainPanel);
        // Load some initial data for demonstration
        loadInitialData();
        updateDisplay();
    }

    private JButton createButton(String text, java.awt.event.ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void loadInitialData() {
        try {
            library.addBook(new Book("978-0321765723", "The C++ Programming Language", "Bjarne Stroustrup"));
            library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));
            library.addStudent(new Student("S001", "Alice"));
            library.addStudent(new Student("S002", "Bob"));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error loading initial data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addBook(ActionEvent e) {
        String isbn = JOptionPane.showInputDialog(this, "Enter ISBN:");
        String title = JOptionPane.showInputDialog(this, "Enter Title:");
        String author = JOptionPane.showInputDialog(this, "Enter Author:");

        // Data Validation
        if (isbn == null || isbn.trim().isEmpty() || title == null || title.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ISBN and Title cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            library.addBook(new Book(isbn, title, author));
            updateDisplay();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addStudent(ActionEvent e) {
        String id = JOptionPane.showInputDialog(this, "Enter Student ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Student Name:");

        // Data Validation
        if (id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID and Name cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            library.addStudent(new Student(id, name));
            updateStudentDisplay();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void issueBook(ActionEvent e) {
        String isbn = JOptionPane.showInputDialog(this, "Enter ISBN of the book to issue:");
        String studentId = JOptionPane.showInputDialog(this, "Enter Student ID:");

        try {
            library.issueBook(isbn, studentId);
            updateDisplay();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to issue book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnBook(ActionEvent e) {
        String isbn = JOptionPane.showInputDialog(this, "Enter ISBN of the book to return:");

        try {
            library.returnBook(isbn);
            updateDisplay();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to return book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDisplay() {
        displayArea.setText("--- Books in Library ---\n");
        library.getAllBooks().forEach(book -> displayArea.append(book.toString() + "\n"));
    }

    private void updateStudentDisplay() {
        displayArea.setText("--- Registered Students ---\n");
        library.getAllStudents().forEach(student -> displayArea.append(student.toString() + "\n"));
    }
}