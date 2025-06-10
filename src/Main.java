package com.library;

import com.library.ui.LibraryGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}