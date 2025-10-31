package com.clarity.app;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

/**
 * Controller for the Settings page
 * Handles user interactions and form submissions
 */
public class SettingsController {

    // Form field references
    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    /**
     * Initialize method called after FXML loading
     */
    @FXML
    public void initialize() {
        // Set up any initial configurations
        System.out.println("Settings Controller initialized");
    }

    /**
     * Handle the Upload Photo button click
     * Opens a file chooser dialog for image selection
     */
    @FXML
    private void handleUploadPhoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Photo");

        // Set extension filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Show open file dialog
        Stage stage = (Stage) fullNameField.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // TODO: Implement photo upload logic
            showInfoAlert("Photo Upload", "Photo selected: " + selectedFile.getName());
            System.out.println("Selected photo: " + selectedFile.getAbsolutePath());
        }
    }

    /**
     * Handle the Save button click
     * Validates and saves the form data
     */
    @FXML
    private void handleSave() {
        // Get current values
        String fullName = fullNameField.getText().trim();

        // Validate full name
        if (fullName.isEmpty()) {
            showErrorAlert("Validation Error", "Please enter your full name.");
            return;
        }

        // TODO: Implement actual save logic (API call, database update, etc.)
        showSuccessAlert("Settings Saved", "Your profile has been updated successfully!");
        System.out.println("Saving settings for: " + fullName);
    }

    /**
     * Show success alert dialog
     */
    private void showSuccessAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Show error alert dialog
     */
    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Show info alert dialog
     */
    private void showInfoAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}