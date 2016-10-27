package pl.spring.module2.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Task {

	public static TaskBuilder New() {
		return new TaskBuilder();
	}

	@NotNull
	private Long Id;

	@Length(max = 12)
	private String subject;
	
	private Date startDate;
	private Date closeDate;

	public String getSubject() {
		return subject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
