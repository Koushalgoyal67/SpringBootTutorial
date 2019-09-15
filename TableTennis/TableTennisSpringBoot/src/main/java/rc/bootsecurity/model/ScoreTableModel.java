package rc.bootsecurity.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scoreTable") 
public class ScoreTableModel {

@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
private int scoreTableId;

@Column(name = "matchNumber")
private int matchNumber;

@Column(name = "team1Name")
private String team1Name;

@Column(name = "team2Name")
private String team2Name;

@Column(name = "team1Id")
private int team1Id;

@Column(name = "team2Id")
private int team2Id;

@Column(name = "team1PlayerId")
private int team1PlayerId;

@Column(name = "team2PlayerId")
private int team2PlayerId;

@Column(name = "team1Score")
private int team1Score;

@Column(name = "team2Score")
private int team2Score;

@Column(name = "date")
private String date;

@Column(name = "slot")
private int slot;

@Column(name = "winMatch")
private int winMatch;

@Column(name = "commentary")
private String commentary;

public int getScoreTableId() {
	return scoreTableId;
}

public void setScoreTableId(int scoreTableId) {
	this.scoreTableId = scoreTableId;
}

public int getMatchNumber() {
	return matchNumber;
}

public void setMatchNumber(int matchNumber) {
	this.matchNumber = matchNumber;
}

public String getTeam1Name() {
	return team1Name;
}

public void setTeam1Name(String team1Name) {
	this.team1Name = team1Name;
}

public String getTeam2Name() {
	return team2Name;
}

public void setTeam2Name(String team2Name) {
	this.team2Name = team2Name;
}

public int getTeam1Id() {
	return team1Id;
}

public void setTeam1Id(int team1Id) {
	this.team1Id = team1Id;
}

public int getTeam2Id() {
	return team2Id;
}

public void setTeam2Id(int team2Id) {
	this.team2Id = team2Id;
}

public int getTeam1PlayerId() {
	return team1PlayerId;
}

public void setTeam1PlayerId(int team1PlayerId) {
	this.team1PlayerId = team1PlayerId;
}

public int getTeam2PlayerId() {
	return team2PlayerId;
}

public void setTeam2PlayerId(int team2PlayerId) {
	this.team2PlayerId = team2PlayerId;
}

public int getTeam1Score() {
	return team1Score;
}

public void setTeam1Score(int team1Score) {
	this.team1Score = team1Score;
}

public int getTeam2Score() {
	return team2Score;
}

public void setTeam2Score(int team2Score) {
	this.team2Score = team2Score;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public int getSlot() {
	return slot;
}

public void setSlot(int slot) {
	this.slot = slot;
}

public int getWinMatch() {
	return winMatch;
}

public void setWinMatch(int winMatch) {
	this.winMatch = winMatch;
}

public String getCommentary() {
	return commentary;
}

public void setCommentary(String commentary) {
	this.commentary = commentary;
}

@Override
public String toString() {
	return "ScoreTableModel [scoreTableId=" + scoreTableId + ", matchNumber=" + matchNumber + ", team1Name=" + team1Name
			+ ", team2Name=" + team2Name + ", team1Id=" + team1Id + ", team2Id=" + team2Id + ", team1PlayerId="
			+ team1PlayerId + ", team2PlayerId=" + team2PlayerId + ", team1Score=" + team1Score + ", team2Score="
			+ team2Score + ", date=" + date + ", slot=" + slot + ", winMatch=" + winMatch + ", commentary=" + commentary
			+ "]";
}



}
