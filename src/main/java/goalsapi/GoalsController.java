package goalsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class GoalsController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping("/")
    public Map<String, String> root() {
        return Map.of("message", "Welcome to the Goals API - Spring Boot");
    }

    @GetMapping("/goals")
    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }

    @PostMapping("/goals")
    public Goal createGoal(@RequestBody Map<String, String> body) {
        Goal goal = new Goal(body.get("title"));
        return goalRepository.save(goal);
    }
    
    @PutMapping("/goals/{id}")
    public Goal updateGoal(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isEmpty()) {
            return null;
        }
        Goal goal = optionalGoal.get();
        if (body.containsKey("title")) {
            goal.setTitle((String) body.get("title"));
        }
        if (body.containsKey("completed")) {
            goal.setCompleted((Boolean) body.get("completed"));
        }
        return goalRepository.save(goal);
    }

    @DeleteMapping("/goals/{id}")
    public Map<String, String> deleteGoal(@PathVariable Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        if (goal.isEmpty()) {
            return Map.of("error", "Goal not found");
        }
        goalRepository.deleteById(id);
        return Map.of("message", "Goal " + id + " deleted");
    }
}