package model;

public class Event {
	private String name;
	private String date;
	private int startTime;
	private int finishTime;
	private String nameTeacher;
	private String faculty;
	private int totalPeople;
	private int [] usados;
	Auditorium auditorios [];
	//Constructor
	public Event(String name, String date, int startTime, int finishTime, String nameTeacher, String faculty,int totalPeople, int[]usados) {
		this.name = name;
		this.date = date;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.nameTeacher = nameTeacher;
		this.faculty = faculty;
		this.totalPeople = totalPeople;
		this.usados=usados;
		auditorios = new Auditorium [8];
	}
	//Getters
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public String getNameTeacher() {
		return nameTeacher;
	}
	public String getFaculty() {
		return faculty;
	}
	public int getTotalPeople() {
		return totalPeople;
	}
	
	@Override
	public String toString() {
		return "Event name: " + name + "\nDate: " + date + "\nStart time: " + startTime + "\nFinish time: " + finishTime
				+ "\nName teacher: " + nameTeacher + "\nFaculty: " + faculty + "\nTotal people: " + totalPeople + "\n";
	}

	public void usoAuditorium(Auditorium audi[]){
		boolean val = false;
		for (int i=0;i<usados.length ;i++ ) {
			auditorios[i]=audi[usados[i]-1];
		}
	}

	public String reportChair(String code,String desc,String audi){
		boolean val = false;
		String msg = "Error: the auditorium is not registered in that event\n";
		for (int i =0;i<auditorios.length && !val ;i++ ) {
			if(auditorios[i]!=null){
				if(auditorios[i].getName().equalsIgnoreCase(audi)){
					msg=auditorios[i].reportChair(code,desc);
				}
			}
		}
		return msg;
	}

	public String showChairEvent(String audi){
		String msg="Error: the event doesn't exist\n";
		for (int i=0;i<eventos.size() ;i++ ) {
			if(eventos.get(i).equalsIgnoreCase(name)){
				msg=event.get(i).showChairEvent();
			}
		}
		return msg;

	}

}
