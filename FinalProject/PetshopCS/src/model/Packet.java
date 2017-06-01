package model;

import java.io.Serializable;

public class Packet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object object;
	private String command;
	
	public Packet(Object object, String command) {
		super();
		this.object = object;
		this.command = command;
	}

	public Packet() {
		// TODO Auto-generated constructor stub
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String string) {
		this.command = string;
	}

	
}
