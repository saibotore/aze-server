package de.tgehring.aze.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name="WorkingTime.findAll", query="SELECT w FROM WorkingTime w")
@XmlRootElement
public class WorkingTime {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToOne
	@JoinColumn(name="person", nullable=false)
	private Person person;
	
	@Column(name="date")
	private String date;
	
	@Column(name="timein")
	private String timeIn;
	
	@Column(name="timeout")
	private String timeOut;
	
	@Column(name="task")
	private String task;
	
	public WorkingTime() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Arbeitszeit [id=" + id + ", person=" + person + ", date="
				+ date + ", timeIn=" + timeIn + ", timeOut=" + timeOut
				+ ", task=" + task + "]";
	}
	
}
