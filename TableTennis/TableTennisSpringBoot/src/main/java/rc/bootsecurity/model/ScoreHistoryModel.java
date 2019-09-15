package rc.bootsecurity.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scoreHistory")
public class ScoreHistoryModel implements Serializable 
{
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int Id;
	 
	  @Column(name = "todayMatchId")
	  private int todayMatchId;
	  
	  @Column(name= "tier")
	  private int tier;
	  
	  @Column(name= "matchNumber")
	  private int matchNumber;	  
	  
	  @Column(name= "teamOneScore")
	  private int teamOneScore;	
	  
	  @Column(name= "teamTwoScore")
	  private int teamTwoScore;
	  
	  @Column(name= "teamOneWin")
	  private int teamOneWin;	
	  
	  @Column(name= "teamTwoWin")
	  private int teamTwoWin;	
	  
	  @Column(name= "winningTeam")
	  private String winningTeam;	
	  
	  @Column(name= "date")
	  private String date;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getTodayMatchId() {
		return todayMatchId;
	}

	public void setTodayMatchId(int todayMatchId) {
		this.todayMatchId = todayMatchId;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public int getTeamOneScore() {
		return teamOneScore;
	}

	public void setTeamOneScore(int teamOneScore) {
		this.teamOneScore = teamOneScore;
	}

	public int getTeamTwoScore() {
		return teamTwoScore;
	}

	public void setTeamTwoScore(int teamTwoScore) {
		this.teamTwoScore = teamTwoScore;
	}

	public int getTeamOneWin() {
		return teamOneWin;
	}

	public void setTeamOneWin(int teamOneWin) {
		this.teamOneWin = teamOneWin;
	}

	public int getTeamTwoWin() {
		return teamTwoWin;
	}

	public void setTeamTwoWin(int teamTwoWin) {
		this.teamTwoWin = teamTwoWin;
	}

	public String getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ScoreHistoryModel [Id=" + Id + ", todayMatchId=" + todayMatchId + ", tier=" + tier + ", matchNumber="
				+ matchNumber + ", teamOneScore=" + teamOneScore + ", teamTwoScore=" + teamTwoScore + ", teamOneWin="
				+ teamOneWin + ", teamTwoWin=" + teamTwoWin + ", winningTeam=" + winningTeam + ", date=" + date + "]";
	}
	  
	  
	  
	  
	  
}
