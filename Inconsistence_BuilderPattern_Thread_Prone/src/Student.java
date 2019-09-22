
final class Student { 

	// instance fields 
	private int id; 
	private String name; 
	private String address; 


	public Student setId(int id) 
	{ 
		this.id = id; 
		return this; 
	} 

	public Student setName(String name) 
	{ 
		this.name = name; 
		return this; 
	} 

	public Student setAddress(String address) 
	{ 
		this.address = address; 
		return this; 
	} 

	@Override
	public String toString() 
	{ 
		return "id = " + this.id + ", name = " + this.name + 
							", address = " + this.address; 
	} 
} 




