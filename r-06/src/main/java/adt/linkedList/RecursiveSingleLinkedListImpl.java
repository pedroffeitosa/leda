package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			size = 1 + this.getNext().size();
		}
		return size;

	}

	@Override
	public T search(T element) {
		T out = null;
		if (element != null && !this.isEmpty()) {
			if (this.getData().equals(element))
				out = this.getData();
			else
				out = this.getNext().search(element);
		}

		return out;

	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.getNext().insert(element);
		}

	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			if (this.getData().equals(element)) {
				if (this.getNext().isEmpty()) {
					this.setData(null);
				} else {
					this.setData(this.getNext().getData());
				}
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		recursiveToArray(array);

		return (T[]) array.toArray();

	}

	private void recursiveToArray(List<T> array) {
		if (!this.isEmpty()) {
			array.add(this.getData());
			this.getNext().recursiveToArray(array);
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}