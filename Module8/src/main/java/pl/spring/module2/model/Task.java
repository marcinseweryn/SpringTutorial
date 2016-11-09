package pl.spring.module2.model;

public class Task {

	private Long Id;

	public Task(Long Id) {
		this.Id = Id;
	}

	@Override
	public String toString() {
		return "Zadanie " + Id;
	}
}
