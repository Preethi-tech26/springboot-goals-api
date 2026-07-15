package goalsapi;

import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed = false;

    // Default constructor (required by JPA)
    public Goal() {
    }

    // Constructor
    public Goal(String title) {
        this.title = title;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}