package controllers; 
  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 
 
import models.Person;;
 

@ManagedBean(name="createPersonMBean")
@SessionScoped 
public class CreatePersonMBean {
 
	//atributo pessoa
	Person person;
	/** 
	* Construtor 
	*/ 
	public CreatePersonMBean() { 
	person = new Person(); 
	} 
	  
	public Person getPerson() { 
	return person; 
	} 
	  
	public void setPerson(Person person) { 
	this.person = person; 
	} 
	  
	/** 
	* Método para realização do cadastro. 
	* @return 
	*/ 
	public String create() { 
		return "/sucess.jsf"; 
	} 
}