package rc.bootsecurity.db;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.ScoreHistoryModel;
@Repository
public interface ScoreHistoryRepo extends JpaRepository<ScoreHistoryModel,Integer> {

}
