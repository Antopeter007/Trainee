package JAXBStudies;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Employeeslist {
	private List<Employee> employees;

	public Employeeslist() {
	}

	public Employeeslist(List<Employee> employees) {
		this.employees = employees;
	}

	@XmlElement

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
