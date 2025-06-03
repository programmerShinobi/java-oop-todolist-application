package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

	private final TodolistRepository todolistRepository;

	public TodolistServiceImpl(TodolistRepository todolistRepository) {
		this.todolistRepository = todolistRepository;
	}

	@Override
	public void showTodolist() {
		Todolist[] model = todolistRepository.getAll();
		System.out.println("TODOLIST");
		for (int i = 0; i < model.length; i++) {
			Todolist todolist = model[i];
			int number = i + 1;

			if (todolist != null) {
				System.out.println(number + ". " + todolist.getTodo());
			}
		}
	}

	@Override
	public void addTodolist(String todo) {
		Todolist todolist = new Todolist(todo);
		todolistRepository.add(todolist);
	}

	@Override
	public void removeTodolist(Integer number) {

	}
}
