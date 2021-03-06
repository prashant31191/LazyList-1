package backend;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Service {

	private Random random = new Random();

	private List<String> firstNames = Arrays.asList("Mike", "Julia", "Brad", "Michael", "John", "Nicole", "Maria",
			"Richard", "Julia");
	private List<String> lastNames = Arrays.asList("Hall", "Robertson", "Orr", "York", "Doe", "Hilton", "Smith",
			"Clarkson");
	private List<String> cities = Arrays.asList("New York", "Toronto", "Turku", "London", "Los Angeles", "Buffalo",
			"Helsinki", "Stockholm");
	private List<String> phoneNumbers = Arrays.asList("+234 242 3443", "+252 352 4222", "+52 020 2202",
			"+235 252 2252", "+252 525 2222", "+345 300 1308", "+20 252 5222", "+101 101 0110");

	private boolean finiteNumberOfPersonsFetched;

	private boolean coupleOfPersonsFetched;

	public List<Person> getMorePersons() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LinkedList<Person> persons = new LinkedList<Person>();
		for (int i = 0; i < 50; ++i) {
			persons.add(createRandomPerson());
		}
		return persons;
	}

	public List<Person> getFiniteNumberOfPersons() {
		if (finiteNumberOfPersonsFetched) {
			return Collections.emptyList();
		}
		finiteNumberOfPersonsFetched = true;
		return getMorePersons();
	}

	public List<Person> getCoupleOfPersons() {
		if (coupleOfPersonsFetched) {
			return Collections.emptyList();
		}
		coupleOfPersonsFetched = true;
		return getMorePersons().subList(0, 2);
	}

	private Person createRandomPerson() {
		Person person = new Person();
		person.setFirstname(randomElement(firstNames));
		person.setLastname(randomElement(lastNames));
		person.setCity(randomElement(cities));
		person.setPhoneNumber(randomElement(phoneNumbers));
		return person;
	}

	private String randomElement(List<String> list) {
		return list.get(random.nextInt(list.size()));
	}

}
