package JAXBStudies;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private String name;
	private float salary;
	private Experiencelist experiencelist;

	public Employee() {
	}

	public Employee(String name, float salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	
	@XmlElement
	public Experiencelist getExperiencelist() {
		return experiencelist;
	}

	public void setExperiencelist(Experiencelist experience2) {
		this.experiencelist = experience2;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", experiencelist=" + experiencelist + "]";
	}

}
