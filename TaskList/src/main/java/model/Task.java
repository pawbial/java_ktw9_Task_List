package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
public class Task {

    private Long id;
    private String content;
    private LocalDate date;
    private String status;


    public Task () {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map <Integer, String> getOptionsMap () {

        Map <Integer,String> statusOptions = new HashMap<>();
        statusOptions.put(1,"Option 1");
        statusOptions.put(2,"Option 2");
        statusOptions.put(3,"Option 3");
        statusOptions.put(4,"Option 4");
        return statusOptions;
    }

    public String getStatusAsOption () {
        Map<Integer, String> optionsMap = getOptionsMap();

        String optionStatus = optionsMap.entrySet().stream().map(option -> "<option value=\"" + option.getKey() + "\">" + option.getValue() + "</option>")
                .collect(Collectors.joining());

        return optionStatus;

    }
}
