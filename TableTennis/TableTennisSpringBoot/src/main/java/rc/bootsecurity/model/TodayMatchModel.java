package rc.bootsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todayMatch") 
public class TodayMatchModel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int todayMatchId;
		
	@Column(name = "teamOne")
	private int teamOne;
	 
	@Column(name = "teamTwo")
	private int teamTwo;

	@Column(name = "date")
	private String date;
	
	@Column(name = "scheduled")
	private String scheduled;

	@Column(name = "teamOneName")
	private String teamOneName;
	
	@Column(name = "teamTwoName")
	private String teamTwoName;

	@Column(name = "slot")
	private int slot;

	
	@Column(name = "match1P1")
	private String match1P1;
	@Column(name = "match1P2")
	private String match1P2;

	@Column(name = "match2P1")
	private String match2P1;
	@Column(name = "match2P2")
	private String match2P2;

	@Column(name = "match3P1")
	private String match3P1;
	@Column(name = "match3P2")
	private String match3P2;
	
	
	@Column(name = "match4P11")
	private String match4P11;
	@Column(name = "match4P12")
	private String match4P12;	
	@Column(name = "match4P21")
	private String match4P21;
	@Column(name = "match4P22")
	private String match4P22;
	
	@Column(name = "match5P11")
	private String match5P11;
	@Column(name = "match5P12")
	private String match5P12;	
	@Column(name = "match5P21")
	private String match5P21;
	@Column(name = "match5P22")
	private String match5P22;
	

	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}

	public int getTodayMatchId() {
		return todayMatchId;
	}

	public void setTodayMatchId(int todayMatchId) {
		this.todayMatchId = todayMatchId;
	}

	public int getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(int teamOne) {
		this.teamOne = teamOne;
	}

	public int getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(int teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeamOneName() {
		return teamOneName;
	}

	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}

	public String getTeamTwoName() {
		return teamTwoName;
	}

	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getMatch1P1() {
		return match1P1;
	}

	public void setMatch1P1(String match1p1) {
		match1P1 = match1p1;
	}

	public String getMatch1P2() {
		return match1P2;
	}

	public void setMatch1P2(String match1p2) {
		match1P2 = match1p2;
	}

	public String getMatch2P1() {
		return match2P1;
	}

	public void setMatch2P1(String match2p1) {
		match2P1 = match2p1;
	}

	public String getMatch2P2() {
		return match2P2;
	}

	public void setMatch2P2(String match2p2) {
		match2P2 = match2p2;
	}

	public String getMatch3P1() {
		return match3P1;
	}

	public void setMatch3P1(String match3p1) {
		match3P1 = match3p1;
	}

	public String getMatch3P2() {
		return match3P2;
	}

	public void setMatch3P2(String match3p2) {
		match3P2 = match3p2;
	}

	public String getMatch4P11() {
		return match4P11;
	}

	public void setMatch4P11(String match4p11) {
		match4P11 = match4p11;
	}

	public String getMatch4P12() {
		return match4P12;
	}

	public void setMatch4P12(String match4p12) {
		match4P12 = match4p12;
	}

	public String getMatch4P21() {
		return match4P21;
	}

	public void setMatch4P21(String match4p21) {
		match4P21 = match4p21;
	}

	public String getMatch4P22() {
		return match4P22;
	}

	public void setMatch4P22(String match4p22) {
		match4P22 = match4p22;
	}

	public String getMatch5P11() {
		return match5P11;
	}

	public void setMatch5P11(String match5p11) {
		match5P11 = match5p11;
	}

	public String getMatch5P12() {
		return match5P12;
	}

	public void setMatch5P12(String match5p12) {
		match5P12 = match5p12;
	}

	public String getMatch5P21() {
		return match5P21;
	}

	public void setMatch5P21(String match5p21) {
		match5P21 = match5p21;
	}

	public String getMatch5P22() {
		return match5P22;
	}

	public void setMatch5P22(String match5p22) {
		match5P22 = match5p22;
	}

	@Override
	public String toString() {
		return "TodayMatchModel [todayMatchId=" + todayMatchId + ", teamOne=" + teamOne + ", teamTwo=" + teamTwo
				+ ", date=" + date + ", scheduled=" + scheduled + ", teamOneName=" + teamOneName + ", teamTwoName="
				+ teamTwoName + ", slot=" + slot + ", match1P1=" + match1P1 + ", match1P2=" + match1P2 + ", match2P1="
				+ match2P1 + ", match2P2=" + match2P2 + ", match3P1=" + match3P1 + ", match3P2=" + match3P2
				+ ", match4P11=" + match4P11 + ", match4P12=" + match4P12 + ", match4P21=" + match4P21 + ", match4P22="
				+ match4P22 + ", match5P11=" + match5P11 + ", match5P12=" + match5P12 + ", match5P21=" + match5P21
				+ ", match5P22=" + match5P22 + "]";
	}

	

	
}