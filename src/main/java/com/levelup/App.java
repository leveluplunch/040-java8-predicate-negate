package com.levelup;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;

/**
 * Hello world!
 *
 */
public class App {

	@Test
	public void predicate_even_java8() {

		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> isEven = (x) -> x % 2 == 0;

		myList.stream().filter(isEven).forEach(System.out::println);
	}

	@Test
	public void predicate_odd_java8() {

		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> isEven = (x) -> x % 2 == 0;

		myList.stream().filter(isEven.negate()).forEach(System.out::println);
	}

	com.google.common.base.Predicate<Integer> isEven = new com.google.common.base.Predicate<Integer>() {
		@Override
		public boolean apply(Integer input) {
			return input % 2 == 0;
		}
	};

	@Test
	public void predicate_guava() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> oddList = FluentIterable.from(numbers)
				.filter(Predicates.not(isEven)).toList();

		System.out.println(oddList);
	}

}
