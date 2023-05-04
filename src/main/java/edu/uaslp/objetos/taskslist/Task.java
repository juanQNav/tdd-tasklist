package edu.uaslp.objetos.taskslist;
import java.time.LocalDateTime;


public class Task {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;

    public Task(){

    }
    public Task(String title, String description, LocalDateTime dueDate, boolean done){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDueDate(LocalDateTime dueDate){
        if(dueDate.isBefore(LocalDateTime.now())) {
            throw new TaskListException("Due date is set in the past");
        }
            this.dueDate = dueDate;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription(){
        return description;
    }
    public LocalDateTime getDueDate(){
        return dueDate;
    }
    public boolean isDone(){
        return done;
    }
}
