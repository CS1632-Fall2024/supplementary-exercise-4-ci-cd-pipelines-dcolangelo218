package edu.pitt.cs;

public class CatImpl implements Cat {

	// TODO: Fill in with member variables
	int id;
	String cat_name;
	boolean out;

	public CatImpl(int id, String name) {
		// TODO: Fill in
		this.id = id;
		this.cat_name = name;
		this.out = false;
	}

	public void rentCat() {
		// TODO: Fill in
		this.out = true;
	}

	public void returnCat() {
		// TODO: Fill in
		this.out = false;
	}

	public void renameCat(String name) {
		// TODO: Fill in
		this.cat_name = name;
	}

	public String getName() {
		// TODO: Fill in
		return this.cat_name;
	}

	public int getId() {
		// TODO: Fill in
		return this.id;
	}

	public boolean getRented() {
		// TODO: Fill in
		return this.out;
	}

	public String toString() {
		// TODO: Fill in
		return String.format("ID %d. %s",  this.id, this.cat_name);
	}

}