package edu.pitt.cs;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*; 

public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
			    // TODO: Return a mock object that emulates the behavior of a real object.
				Cat fakecat = Mockito.mock(Cat.class);

				when(fakecat.getId()).thenReturn(id);
            	when(fakecat.getName()).thenReturn(name);

				final boolean[] isRented = {false};

				doAnswer(invocation -> {
					isRented[0] = true;
					return null;
				}).when(fakecat).rentCat();
				doAnswer(invocation -> {
					isRented[0] = false;
					return null;
				}).when(fakecat).returnCat();
				when(fakecat.getRented()).thenAnswer(invocation -> isRented[0]);

				when(fakecat.toString()).thenAnswer(invocation -> "ID " + id + ". " + name);

				doAnswer(invocation -> {
					String newName = invocation.getArgument(0, String.class);
					when(fakecat.getName()).thenReturn(newName);
					when(fakecat.toString()).thenReturn("ID " + id + ". " + newName);
					return null;
				}).when(fakecat).renameCat(anyString());
				
				return fakecat;
			default:
				assert(false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.
	
	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
