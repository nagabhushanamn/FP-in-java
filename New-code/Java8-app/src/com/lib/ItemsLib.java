package com.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ItemsLib {

	public static <T> void forEach(List<T> items, Consumer<T> consumer) {
		for (T item : items) {
			consumer.accept(item);
		}
	}

	public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
		List<T> filteredList = new ArrayList<>();
		for (T item : items) {
			if (predicate.test(item)) {
				filteredList.add(item);
			}
		}
		return filteredList;
	}

	public static <T, R> List<R> map(List<T> items, Function<T, R> function) {
		List<R> mappedList = new ArrayList<>();
		for (T item : items) {
			R mappedValue = function.apply(item);
			mappedList.add(mappedValue);
		}
		return mappedList;
	}

}
