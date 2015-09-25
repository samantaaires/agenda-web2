package controllers;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import models.Contact;


@ManagedBean(name="contactsMBean")
@SessionScoped
public class ContactsMBean {
	Contact contact;
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	List<Contact> contacts;
	public ContactsMBean() {
		// TODO Auto-generated constructor stub
		contacts = new ArrayList<Contact>();
		contact = new Contact();
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public String newContact(){
		return "/formContact.jsf";
	}
	
	public String createNewContact(){
	     //validando se foi informado um telefone/celular para contato.
        if(contact.getName().equals("") && contact.getPhone().equals("")){
            FacesMessage msg = new FacesMessage("Para efetivar o cadastro, é necessário informar um nome e telefone.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("", msg);
            return "/formContact.jsf";
        }
        contacts.add(contact);
        contact = new Contact();
        return "/listContacts.jsf";
    }
}
