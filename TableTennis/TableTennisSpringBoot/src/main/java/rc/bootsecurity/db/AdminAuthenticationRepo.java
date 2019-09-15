package rc.bootsecurity.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.AdminAuthenticationModel;
@Repository
public interface AdminAuthenticationRepo extends JpaRepository<AdminAuthenticationModel,Integer>{
	List<AdminAuthenticationModel> findByAdminName(String adminName);
	
	@Query(
			  value = "select * from admin_authentication where admin_name=?1 && admin_password=?2", 
			  nativeQuery = true)
	List<AdminAuthenticationModel> adminAuthentication(String adminNameString , String adminPassword ); 
	
//	@Query("select * from admin_authentication ")
//	 List<AdminAuthenticationModel> adminAuthentication( ); 
	

}
