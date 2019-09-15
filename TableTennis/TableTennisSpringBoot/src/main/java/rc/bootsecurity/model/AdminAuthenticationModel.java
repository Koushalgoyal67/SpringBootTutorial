package rc.bootsecurity.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AdminAuthentication")
public class AdminAuthenticationModel implements Serializable{
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	 

	 @Column(name = "adminName")
	 private String adminName;
		 
    @Column(name = "adminPassword")
	private String adminPassword;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	  
	  
	  @Override
	public String toString() {
		return "AdminAuthenticationModel [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ "]";
	}


}
