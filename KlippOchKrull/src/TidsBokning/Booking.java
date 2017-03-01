package TidsBokning;

import java.time.LocalDateTime;

public class Booking {

	private LocalDateTime startTid;
	private LocalDateTime slutTid;
	private String namn;

	public LocalDateTime getSlutTid() {
		return slutTid;
	}

	public LocalDateTime getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalDateTime startTid) {
		this.startTid = startTid;
	}

	public void setSlutTid(LocalDateTime slutTid) {
		this.slutTid = slutTid;
	}
	
	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}
}
