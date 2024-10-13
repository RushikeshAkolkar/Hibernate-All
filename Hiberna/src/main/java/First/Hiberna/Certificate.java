//video - 10
package First.Hiberna;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String cources;
	private String duration;
	
	public String getCources() {
		return cources;
	}
	public void setCources(String cources) {
		this.cources = cources;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Certificate(String cources, String duration) {
		super();
		this.cources = cources;
		this.duration = duration;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
