package model;
import java.time.*;
/**import java.time.*;
class Main {
  public static void main(String[] args) {
     int inicio =21;
     int fer = 23;
     String ini= String.valueOf(inicio)+":00:00";
     String fin = String.valueOf(fer)+":00:00";
     LocalTime start = LocalTime.parse(ini);
     LocalTime finish = LocalTime.parse(fin);
   LocalTime now = LocalTime.now();
   if(now.isAfter(start) && now.isBefore(finish)){
     System.out.println("Did it!");
   }
  }
}
*/
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
		String msg="Error: the auditorium isn´t registered in this event\n";

		boolean val = false;
		for (int i=0;i<auditorios.length && !val ;i++ ) {
			if(auditorios[i]!=null){
				if(auditorios[i].getName().equalsIgnoreCase(audi)){

				}
			}
		}
		return msg;

	}

}
