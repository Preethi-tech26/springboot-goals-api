package goalsapi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GoalRequest {

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}