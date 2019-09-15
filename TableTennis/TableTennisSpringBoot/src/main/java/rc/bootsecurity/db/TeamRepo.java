package rc.bootsecurity.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.TeamModel;

@Repository
public interface TeamRepo  extends JpaRepository<TeamModel,Integer> {
	List<TeamModel> findByTeamIdGreaterThan(int id);
}


