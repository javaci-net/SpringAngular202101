package chapter30;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		String[] names = { "John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john" };

		// Display the first four names sorted
		Stream<String> s = Stream.of(names);
		
		Consumer<String> c = System.out::print;
		
		s.limit(4).map(e -> e + " ").sorted().forEach(c);

		// Skip four names and display the rest sorted ignore case
		System.out.println();
		Stream.of(names).skip(4).sorted((e1, e2) -> e1.compareToIgnoreCase(e2)).forEach(e -> System.out.print(e + " "));

		System.out.println();
		Stream.of(names).skip(4).sorted(String::compareToIgnoreCase).forEach(e -> System.out.print(e + " "));

		Stream.of(names)
			.filter(e -> e.length() > 4)
			.max(String::compareTo)
			.ifPresent(i -> System.out.println("\nLargest string with length > 4: " + i));
			
		System.out.println("Smallest string alphabetically: " + Stream.of(names).min(String::compareTo).get());

		System.out.println("Stacy is in names? " + Stream.of(names).anyMatch(e -> e.equals("Stacy")));

		System.out.println("All names start with a capital letter? "
				+ Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0))));

		System.out.println("No name begins with Ko? " + Stream.of(names).noneMatch(e -> e.startsWith("Ko")));

		System.out.println("Number of distinct case-insensitive strings: "
				+ Stream.of(names).map(e -> e.toUpperCase()).distinct().count());

		System.out.println("First element in this stream in lowercase: "
				+ Stream.of(names).map(String::toLowerCase).findFirst().get());

		System.out.println(
				"Skip 4 and get any element in this stream: " + Stream.of(names).skip(4).sorted().findAny().get());

		Object[] namesInLowerCase = Stream.of(names).map(String::toLowerCase).limit(6).skip(4).toArray();
		System.out.println(java.util.Arrays.toString(namesInLowerCase));
		
	}
}
