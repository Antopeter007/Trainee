package JAXBStudies;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement
public class Experience {
	private String name;
	private double CTC;
	private String EXCompany;

	public Experience(String name, double cTC, String eXCompany) {
		super();
		this.name = name;
		CTC = cTC;
		EXCompany = eXCompany;
	}

	public Experience(List<Experience> experience) {
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public double getCTC() {
		return CTC;
	}

	public void setCTC(double cTC) {
		CTC = cTC;
	}

	@XmlElement
	public String getEXCompany() {
		return EXCompany;
	}

	public void setEXCompany(String eXCompany) {
		EXCompany = eXCompany;
	}
}
