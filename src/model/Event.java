package model;
import java.time.*;
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

	public String usoAuditorium(Auditorium audi[]){
		boolean val = false;
		String msg = "";
		for (int i=0;i<usados.length ;i++ ) {
			auditorios[i]=audi[usados[i]-1];
			msg="Event registered sucessfully";
		}
		return msg;
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
		LocalTime horaActual = LocalTime.now();
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaEvento = LocalDate.parse(date);
		String help = String.valueOf(startTime);
		String help2 = String.valueOf(finishTime);
		LocalTime inicioEvent = LocalTime.parse(help+":00:00");
		LocalTime finalEvent = LocalTime.parse(help2+":00:00");
		if(startTime<10){
			inicioEvent = LocalTime.parse("0"+help+":00:00");
		}
		if(finishTime<10){
			finalEvent = LocalTime.parse("0"+help2+":00:00");
		}	
		for (int i=0;i<auditorios.length && !val ;i++ ) {
			if(auditorios[i]!=null){
				if(auditorios[i].getName().equalsIgnoreCase(audi)){
					if(fechaEvento.compareTo(fechaActual)==0){
						if(horaActual.isAfter(inicioEvent) && horaActual.isBefore(finalEvent)){
							auditorios[i].setStatus(Auditorium.OCUPADO+"/ Event: "+name);
							msg="$: Available/ #: Deficient/ (): Occupied\n";
							auditorios[i].ocuparChair();
							msg+=auditorios[i].showChairs();
							val=true;
						}
						else{
							auditorios[i].setStatus(Auditorium.DISPONIBLE);
							auditorios[i].desocuparChair();
							msg="$: Available/ #: Deficient/ (): Occupied\n";
							msg+=auditorios[i].showChairs();
						}
					}
					else{
						auditorios[i].setStatus(Auditorium.DISPONIBLE);
						auditorios[i].desocuparChair();
						msg="$: Available/ #: Deficient/ (): Occupied\n";
						msg+=auditorios[i].showChairs();
					}
				}
			}
		}
		return msg;

	}

	public String porcenDefectuosas(String audi){
		boolean val=false;
		String msg ="Error: the auditorium isn´t registered in this";
		for (int i =0;i<auditorios.length && !val ;i++ ) {
			if(auditorios[i]!=null){
				msg= auditorios[i].porcenDefectuosas();
				val=true;
			}
			else{
				val=true;
			}
		}
		return msg;

	}	
}
