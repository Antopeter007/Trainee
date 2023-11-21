package JAXBStudies;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Employees1 {
	public static void main(String[] args) throws Exception {
		JAXBContext contextObj = JAXBContext.newInstance(Employeeslist.class);
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Employee emp1 = new Employee("Anto Peter", 80000);

		Experience ex = new Experience("Bala", 4.5, "BSIT");
		
		ArrayList<Experience> experience = new ArrayList<>();
		experience.add(ex);

		Experiencelist exp = new Experiencelist();
		exp.setExperience(experience);

		emp1.setExperiencelist(exp);
		ArrayList<Employee> employee = new ArrayList<>();
		employee.add(emp1);

		Employeeslist employeesWrapper = new Employeeslist(employee);

		marshallerObj.marshal(employeesWrapper, new FileOutputStream("C:\\Peter\\peter/employees.xml"));
	}
}
