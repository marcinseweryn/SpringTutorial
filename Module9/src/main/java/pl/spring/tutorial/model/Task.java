package pl.spring.tutorial.model;

import java.text.ParseException;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import pl.spring.tutorial.Util;

public class Task {

	public static TaskBuilder New() {
		return new TaskBuilder();
	}

	private Long Id;
	@NotNull
	@Length(min=5,max=255)
	private String subject;
	
	@NotNull
	@Future
	private Date startDate;

	@NotNull
	@Future
	private Date closeDate;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}	

	public String getSubject() {
		return subject;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCloseDate() {
		return closeDate;
	}

	public static Task addTask(String subject, String startDate, String closeDate ) throws ParseException{
		
		Task task = Task.New().withSubject(subject)
				.startsOn(Util.createDate(startDate))
				.closedOn(Util.createDate(closeDate))
				.build();
		return task;
	}
	
	@Override
	public String toString() {
		return "Zadanie " + Id + " Temat: " + subject + " Start: " + startDate + " Koniec: " + closeDate + "\n";
	}


	public static class TaskBuilder {

		private Task task;

		private TaskBuilder() {
			task = new Task();
		}

		public TaskBuilder withId(Long Id) {
			task.Id = Id;
			return this;
		}

		public TaskBuilder withSubject(String subject) {
			task.subject = subject;
			return this;
		}

		public TaskBuilder startsOn(Date start) {
			task.startDate = start;
			return this;
		}

		public TaskBuilder closedOn(Date close) {
			task.closeDate = close;
			return this;
		}

		public Task build() {
			return task;
		}
	}

}
