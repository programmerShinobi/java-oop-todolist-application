package repository;

import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

	public Todolist[] data = new Todolist[10];

	@Override
	public Todolist[] getAll() {
		return data;
	}

	public boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				// model masih ada yang kosong/NULL
				isFull = false;
				break;
			}
		}

		return  isFull;
	}

	public void resizeIfFull() {
		// Jika penuh, maka resize ukuran array 2x lipat
		if (isFull()) {
			Todolist[] temp = data;
			data = new Todolist[data.length * 2];

			for (int i = 0; i < temp.length; i++) {
				data[i] = temp[i];
			}
		}
	}

	@Override
	public void add(Todolist todolist) {
		resizeIfFull();

		// tambahkan ke posisi yang data array bernilai NULL
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				data[i] = todolist;
				break;
			}
		}
	}

	@Override
	public boolean remove(Integer number) {
		Integer editNumberWithMinusOne= number - 1;
		if ((editNumberWithMinusOne) >= data.length) {
			return false;
		} else if (data[editNumberWithMinusOne] == null) {
			return false;
		} else {
			for (int i = editNumberWithMinusOne; i < data.length; i++) {
				if (i == data.length - 1) {
					data[i] = null;
				} else {
					data[i] = data[i + 1];
				}
			}

			return true;
		}
	}
}
