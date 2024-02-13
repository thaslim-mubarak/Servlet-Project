package com.DTO;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Task implements Comparable<Task> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@SequenceGenerator(name = "id", initialValue = 201, allocationSize = 1, sequenceName = "task_id")
	int id;
	String description;
	@CreationTimestamp
	LocalDateTime created_on;
	LocalDateTime completed_on;
	String status;

	public Task() {
		super();
	}

	public Task(String description, String status) {
		super();
		this.description = description;
		this.status = status;
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

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public LocalDateTime getCompleted_on() {
		return completed_on;
	}

	public void setCompleted_on(LocalDateTime completed_on) {
		this.completed_on = completed_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", created_on=" + created_on + ", completed_on="
				+ completed_on + ", status=" + status + "]";
	}

	@Override
	public int compareTo(Task t) {

		if (t.status.equals("Open"))
			return 1;
		else
			return -1;

	}

}
