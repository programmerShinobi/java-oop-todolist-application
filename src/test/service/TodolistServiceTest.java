package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {
	public static void main(String[] args) {
		testRemoveTodolist();
	}

	public static void testShowTodolist() {
		TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
		todolistRepository.data[0] = new Todolist("Belajar Java Dasar");
		todolistRepository.data[1] = new Todolist("Belajar Java OOP");
		todolistRepository.data[2] = new Todolist("Belajar Java Standard Classes");
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

		todolistService.showTodolist();
	}

	public static void testAddTodolist() {
		TodolistRepository todolistRepository = new TodolistRepositoryImpl();
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

		todolistService.addTodolist("Belajar Java Dasar");
		todolistService.addTodolist("Belajar Java OOP");
		todolistService.addTodolist("Belajar Java Standard classes");

		todolistService.showTodolist();
	}

	public static void testRemoveTodolist() {
		TodolistRepository todolistRepository = new TodolistRepositoryImpl();
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

		todolistService.addTodolist("Belajar Java Dasar");
		todolistService.addTodolist("Belajar Java OOP");
		todolistService.addTodolist("Belajar Standard Classes");

		todolistService.showTodolist();
		todolistService.removeTodolist(4);
		todolistService.removeTodolist(2);
		todolistService.showTodolist();
		todolistService.removeTodolist(1);
		todolistService.showTodolist();
		todolistService.removeTodolist(2);
		todolistService.showTodolist();
		todolistService.removeTodolist(1);
		todolistService.showTodolist();


	}
}
