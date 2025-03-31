package task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable{
	//Used for serializable
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String title;
    private String description;
    private int priority;
    private LocalDateTime creationDate;
    private boolean completed;
    
    public Task(int id, String title,String description, int priority, LocalDateTime creationDate) {
    	this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.creationDate = creationDate;
        this.completed = false;
    }
    
    
    public String getTitle() {
        return title;
    }
    
    public int getId() {
		return id;
	}
    
    public String getDescription() {
        return description;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted() {
        this.completed = true;
    }
    
    
    public LocalDateTime getCreationDate() {
		return creationDate;
	}


	public int getPriority() {
		return priority;
	}


	@Override
    public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YY-MM-DD hh:mm"); // Example: 01:30:45 PM

        // Format the LocalTime using the formatter
        String formattedTime = creationDate.format(formatter);
        return "Task "+id+" [" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + formattedTime +"]";
    }
}

