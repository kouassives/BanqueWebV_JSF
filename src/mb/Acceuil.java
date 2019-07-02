package mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import metier.session.IBanqueLocal;

@ManagedBean(name="Acceuil")
@RequestScoped
public class Acceuil {
	@EJB
	private IBanqueLocal metier;
	
	private void met(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec= context.getExternalContext();
		if(ec.equals(true)) {
			
		}
	}
	
}
