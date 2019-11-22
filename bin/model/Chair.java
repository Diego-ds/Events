package model;

public class Chair {
	private String status;
	private String code;
	private String desc;
	public static final String OPERATIVA = "Operational";
	public static final String DEFECTUOSA = "Deficient";
	//Constructor
	public Chair(String status, String code) {
		this.status = status;
		this.code = code;
	}
	//Getters and setters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setDesc(String desc){
		this.desc=desc;
	}
	
}
