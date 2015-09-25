package controllers;

import javax.faces.bean.SessionScoped; 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import models.User;


@ManagedBean(name="loginMBean")
@SessionScoped
public class LoginMBean {

    User user;
    
    public User getUser() {
		return user;
	}
    
	public void setUser(User user) {
		this.user = user;
	}
	
	public LoginMBean() {
        user = new User();
    }
	
    public String login() {
        //validando se foi informado um telefone/celular para contato.
        if(user.getUsername().equals("") && user.getPassword().equals("")){
            FacesMessage msg = new FacesMessage("Para efetivar o login, é necessário informar um nome de usuário e senha.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("", msg);
            System.out.println("Aquiu");
            return "/login.jsf";
        }
        return "/listContacts.jsf";
    }
    
    public String register(){
    	return "/form.jsf";
    }
    

}
