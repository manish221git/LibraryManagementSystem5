# 📚 Library Management System

A simple Java-based Library Management System with a graphical user interface (GUI) built using Swing. This project demonstrates core object-oriented programming principles, event handling, and basic data validation.

## ✨ Core Features

* **Book Management**: Add new books to the library.
* **Student Management**: Register new students.
* **Issue and Return Books**: Manage the process of borrowing and returning books.
* **View Records**: Display lists of all books and registered students.
* **Data Validation**: Ensures that essential data (like ISBN and Student ID) is not empty.
* **Error Handling**: Provides clear feedback for common errors, such as trying to add a duplicate book or issuing an already issued book.

## 🛠️ Built With

* **Java**: The core programming language.
* **Swing**: For the graphical user interface.

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Java Development Kit (JDK) 8 or higher.
* An IDE like IntelliJ IDEA, Eclipse, or VS Code with Java support.

### Installation & Running

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/your-username/LibraryManagementSystem.git](https://github.com/your-username/LibraryManagementSystem.git)
    ```
2.  **Navigate to the project directory:**
    ```sh
    cd LibraryManagementSystem
    ```
3.  **Compile the Java files:**
    If you are in the `src` directory:
    ```sh
    javac com/library/model/*.java com/library/service/*.java com.library/ui/*.java com/library/*.java
    ```
4.  **Run the application:**
    From the `src` directory, execute the `Main` class:
    ```sh
    java com.library.Main
    ```
    Alternatively, you can run the `Main.java` file directly from your IDE.

## 📝 How to Use

1.  **Launch the application** to see the main window.
2.  **Add a Book**: Click "Add Book" and enter the ISBN, title, and author.
3.  **Add a Student**: Click "Add Student" and enter the student's ID and name.
4.  **Issue a Book**: Click "Issue Book", and provide the ISBN of the book and the ID of the student borrowing it.
5.  **Return a Book**: Click "Return Book" and enter the ISBN of the book being returned.
6.  **View Information**: Use the "List Books" and "List Students" buttons to refresh the display with the latest information.

## 💡 Innovation and Code Quality

* **Modular Design**: The project is structured into `model`, `service`, and `ui` packages, promoting separation of concerns and maintainability.
