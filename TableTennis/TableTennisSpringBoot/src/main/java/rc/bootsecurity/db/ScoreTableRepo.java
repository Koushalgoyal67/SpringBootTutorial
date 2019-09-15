package rc.bootsecurity.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rc.bootsecurity.model.ScoreTableModel;
@Repository
public interface ScoreTableRepo extends JpaRepository<ScoreTableModel,Integer> {
List<ScoreTableModel> findByDate(String date );

}