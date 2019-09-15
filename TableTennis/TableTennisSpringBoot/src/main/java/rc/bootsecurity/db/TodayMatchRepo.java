package rc.bootsecurity.db;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.TodayMatchModel;
@Repository
public interface TodayMatchRepo extends JpaRepository<TodayMatchModel,Integer> 
{
	List<TodayMatchModel> findByDate(String date);
	
	

}