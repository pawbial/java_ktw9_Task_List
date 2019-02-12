package repository;

import model.Task;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;
    private String content;
    private LocalDate date;
    private String status;

    public TaskDTO() {

    }

    public TaskDTO(Task task) {
        this.content = task.getContent();
        this.date = task.getDate();
        this.status = task.getStatus();
        this.id = task.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
