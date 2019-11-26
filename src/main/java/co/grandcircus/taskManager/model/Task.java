package co.grandcircus.taskManager.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String description;
	GregorianCalendar dueDate;
	Boolean complete;
	
	@ManyToOne
	private User owner;
	
	public Task() {}

	public Task(int id, String description, GregorianCalendar dueDate, Boolean complete, User owner) {
		super();
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.complete = false;
		this.owner = owner;
	}

	public Task(String description, GregorianCalendar dueDate, Boolean complete, User owner) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GregorianCalendar getDueDate() {
		return dueDate;
	}
	
	public String getCalString() {
		return (dueDate.get(GregorianCalendar.MONTH) + 1) + "-" + dueDate.get(GregorianCalendar.DAY_OF_MONTH) + "-" + dueDate.get(GregorianCalendar.YEAR)
		+ " at " + dueDate.get(GregorianCalendar.HOUR) + ":" + dueDate.get(GregorianCalendar.MINUTE) + " " + dueDate.get(GregorianCalendar.AM_PM);
	} 

	public void setDueDate(GregorianCalendar dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", dueDate=" + dueDate + ", complete=" + complete
				+ ", owner=" + owner + "]";
	}
	
}
