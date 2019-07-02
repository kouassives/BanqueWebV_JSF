package mb;

import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="Other")
@RequestScoped
public class other {
	private String arg1;

	public String getArg1() {
		return arg1;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public String onLoad(){
		System.out.println("Passerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	return null;
	}
	
}
