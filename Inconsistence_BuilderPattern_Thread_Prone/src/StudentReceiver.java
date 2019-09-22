
// Client Side Code 
class StudentReceiver { 

	private final Student student = new Student(); 

	public StudentReceiver() 
	{ 

		Thread t1 = new Thread(new Runnable() { 
			public void run() 
			{ 
				student.setId(1).setName("Ram").setAddress("Noida"); //Method Chainig
			} 
		}); 

		Thread t2 = new Thread(new Runnable() { 

			public void run() 
			{ 
				student.setId(2).setName("Shyam").setAddress("Jaipur");  //Method Chainig
			} 
		}); 

		t1.start(); 
		t2.start(); 
	} 

	public Student getStudent() 
	{ 
		return student; 
	} 
} 
