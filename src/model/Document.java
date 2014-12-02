package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controller.MainController;

public class Document {
	
	/**
	 * Document constructor. Calls initialize method
	 */
	public Document(){
		this.initialize();
	}
	
	/**
	 * Set field modified in false and assign a empty name
	 * also set field schema with the initial code.
	 */
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
	
	/**
	 * Read from a ObjectInputStream the name and
	 * the string on the document and set it
	 * @param ois
	 */
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
	
	/**
	 * Write on a ObjectOutputStream the schema and the 
	 * name of the document. Also set the document as non-
	 * modified
	 * @param oos
	 */
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
	
	/**
	 * Return the boolean modified value
	 * @return
	 */
	public boolean isModified()
	{
		return modified;
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
