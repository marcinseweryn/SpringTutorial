package pl.spring.module2.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Task {

	public static TaskBuilder New() {
		return new TaskBuilder();
	}

	private Long Id;

	private String subject;
	private Date startDate, closeDate;

	public String getSubject() {
		return subject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	@Override
	public String toString() {
		return "Zadanie " + Id + " Temat: " + subject + " Start: " + startDate + " Koniec: " + closeDate + "\n";
	}

	public PropertiesMapBuilder NewMap() {
		return new PropertiesMapBuilder(this);
	}

	public static class PropertiesMapBuilder {

		private Map<String, Object> propertiesMap = new HashMap<String, Object>();
		private Task task;

		public PropertiesMapBuilder(Task task) {
			this.task = task;
		}

		public PropertiesMapBuilder subject() {
			propertiesMap.put("Subject", task.getSubject());
			return this;
		}

		public PropertiesMapBuilder startDate() {
			propertiesMap.put("Start_date", task.getStartDate());
			return this;
		}

		public PropertiesMapBuilder closeDate() {
			propertiesMap.put("Close_date", new Date(task.getCloseDate().getTime()));
			return this;
		}

		public Map<String, Object> bulid() {
			return propertiesMap;
		}

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
