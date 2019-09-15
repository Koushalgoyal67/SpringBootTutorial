package rc.bootsecurity.model;

//import org.json.JSONArray;
//import org.json.JSONObject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "team")
public class TeamModel implements Serializable 
{
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int teamId;
 
  @Column(name = "teamOwner")
  private String teamOwner;
 
  @Column(name = "teamName")
  private String teamName;

public long getTeamId() {
	return teamId;
}

public void setTeamId(int teamId) {
	this.teamId = teamId;
}

public String getTeamOwner() {
	return teamOwner;
}

public void setTeamOwner(String teamOwner) {
	this.teamOwner = teamOwner;
}

public String getTeamName() {
	return teamName;
}

public void setTeamName(String teamName) {
	this.teamName = teamName;
}

@Override
public String toString() {
	return "Team [teamId=" + teamId + ", teamOwner=" + teamOwner + ", teamName=" + teamName + "]";
}
 
}
