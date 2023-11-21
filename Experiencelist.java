package JAXBStudies;

import java.util.List;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement
public class Experiencelist {
	private List<Experience> experience;

	public Experiencelist() {

	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public Experiencelist(List<Experience> experience) {
		this.experience = experience;
	}

}
