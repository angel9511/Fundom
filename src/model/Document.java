package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.MainController;

public class Document {

	public Document(){
		this.initialize();
	}
	
	public void initialize()
	{
		modified = false;
		name = "";
	    schema =  "inicio \n"
				+ "\t elementos \n"
				+ "\n"
				+ "\t animacion \n"
				+ "\n"
				+ "FUN";	
	}
	
	@SuppressWarnings("unchecked")
	public void load(ObjectInputStream ois) {
		try {		
			schema = (String)ois.readObject();
			name = (String)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(schema);
		setModified(false);
	}
	

	public void save(ObjectOutputStream oos) {

		try {
			oos.writeObject( schema );
			oos.writeObject( name );
			setModified( false );
			System.out.println(schema);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public String getSchema() {
		return schema;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean isModified()
	{
		return modified;
	}
	
	public void setText(String t)
	{
		schema = t;
	}
	
	public void setModified(boolean modified)
	{
		this.modified = modified;
	}
	
	private String schema;
	private String name;
	private boolean modified;
}
