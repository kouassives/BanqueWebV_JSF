package mb;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import metier.entites.Compte;
import metier.session.IBanqueLocal;
import util.CookieHelper;
import util.SessionHelper;

@ManagedBean(name="BanqueMB")
@RequestScoped
public class BanqueMB{
	@EJB
	private IBanqueLocal metier;
	private Long code1;
	private Long code2;
	private double montant;
	
	@PostConstruct
	public void init()
	{
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(FacesContext.class.getPackage().getImplementationVersion());
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	public String verser() {	
		metier.verser(montant, code1);
		System.out.println(FacesContext.class.getPackage().getImplementationVersion());
		return "succes";
	}
	public String retirer()
	{
		metier.retirer(montant, code1);
		return "succes";
	}
	public String virement()
	{
		metier.virement(montant, code1, code2);
		return "succes";
	}
	public String ajouter()
	{
		metier.addCompte(new Compte(0.0,new Date(),true));
		return "succes";
	}
	public List<Compte> getListComptes(){
		return metier.getAllComptes();
	}
	public Long getCode1() {
		return code1;
	}
	public void setCode1(Long code1) {
		this.code1 = code1;
	}
	public Long getCode2() {
		return code2;
	}
	public void setCode2(Long code2) {
		this.code2 = code2;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String goToPage() {
		return "Acceuil.xhtml";
	}
	
	public String goOther() {
		CookieHelper.setCookie("Prenom", "KOUASSI",-1);
		SessionHelper.setSession("code1", code1.toString());
		return "other";
	}
}
