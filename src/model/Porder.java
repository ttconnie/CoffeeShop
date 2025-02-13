package model;

import javax.swing.JTextField;

public class Porder {
    private Integer id;
    private String name;
    private Integer acoffee;
    private Integer mcoffee;
    private Integer ccoffee;
   
	public Porder(Integer id, String name, Integer acoffee, Integer mcoffee, Integer ccoffee) {
		super();
		this.id = id;
		this.name = name;
		this.acoffee = acoffee;
		this.mcoffee = mcoffee;
		this.ccoffee = ccoffee;
	
	}
	/*
	public Porder(String name2, JTextField acoffee2, JTextField mcoffee2, JTextField ccoffee2) {
		super();
		// TODO Auto-generated constructor stub
	}
	*/
	public Porder() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAcoffee() {
		return acoffee;
	}
	public void setAcoffee(Integer acoffee) {
		this.acoffee = acoffee;
	}
	public Integer getMcoffee() {
		return mcoffee;
	}
	public void setMcoffee(Integer mcoffee) {
		this.mcoffee = mcoffee;
	}
	public Integer getCcoffee() {
		return ccoffee;
	}
	public void setCcoffee(Integer ccoffee) {
		this.ccoffee = ccoffee;
	}
	


}