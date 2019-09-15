package rc.bootsecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class PlayerModel implements Serializable 
{
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int playerId;
	 
	  @Column(name = "playerName")
	  private String playerName;
	 
	  @Column(name = "teamId")
	  private String teamId;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "PlayerModel [playerId=" + playerId + ", playerName=" + playerName + ", teamId=" + teamId + "]";
	}


	}
