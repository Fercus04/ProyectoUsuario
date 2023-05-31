package Proyecto;

import java.time.LocalDate;

public class Usuario {
	private String name;
    private String email;
    private String contrasinal;
    private String web;
    private String nacemento;

    public Usuario(String email, String contrasinal, String web, String nacemento) {
        this.email = email;
        this.contrasinal = contrasinal;
        this.web = web;
        this.nacemento = nacemento;
    }

    public Usuario(String user, String pass, String mail, String url, String fechaString) {
    	this.name = user;
    	this.email = mail;
        this.contrasinal = pass;
        this.web = url;
        this.nacemento = fechaString;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getNacemento() {
        return nacemento;
    }

    public void setNacemento(String nacemento) {
        this.nacemento = nacemento;
    }
}

