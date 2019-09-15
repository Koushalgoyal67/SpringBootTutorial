package rc.bootsecurity.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.PlayerModel;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerModel,Integer> 
{
	List<PlayerModel> findByTeamIdGreaterThan(int id);
	

}