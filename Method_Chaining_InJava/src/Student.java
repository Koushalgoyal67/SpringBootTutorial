
// Java code to demonstrate method chaining 
final class Student { 

	// instance fields 
	private int id; 
	private String name; 
	private String address;
	public int getId() {
		return id;
	}
	public Student setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Student setName(String name) {
		this.name = name;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Student setAddress(String address) {
		this.address = address;
		return this;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	} 


} 

