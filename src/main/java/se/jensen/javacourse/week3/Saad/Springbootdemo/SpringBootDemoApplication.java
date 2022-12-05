package se.jensen.javacourse.week3.Saad.Springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@SpringBootApplication
@RestController
public class SpringBootDemoApplication {

	private Person person;
	private double num;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	@GetMapping("/author")
	public Person getAuthor(){
		person = new Person("Saad", "Shafe", 21);
		return person;
	}
	@GetMapping("/author/name")
	public String getAuthorName(){
		return person.getFirstname();
	}
	@GetMapping("/square-number/{num}")
	public double getSquareNumber(@PathVariable String num){
		try {
			double number = Double.parseDouble(num);
			return Math.pow(number, 2);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("You have entered an invalid input, try with num, deci....");
		}

		return 0;
	}
	class Person{
		private  String firstname;
		private  String lastname;
		private int age;

		public Person(String firstname, String lastname, int age) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.age = age;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"firstname='" + firstname + '\'' +
					", lastname='" + lastname + '\'' +
					", age=" + age +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return age == person.age && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname);
		}

		@Override
		public int hashCode() {
			return Objects.hash(firstname, lastname, age);
		}
	}

}
