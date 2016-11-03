package pl.spring.tutorial.model;

import java.text.ParseException;
import java.util.Date;
import pl.spring.tutorial.Util;

public class Task {

	public static TaskBuilder New() {
		return new TaskBuilder();
	}

	private Long Id;
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
