package model;
import java.time.*;
import java.util.ArrayList;
//javac model/Auditorium.java model/Chair.java model/Event.java model/University.java ui/Main.java
public class University {
	private String name;
	Auditorium auditorios [];
	ArrayList <Event> eventos;

	public University(String name) {
		this.name = name;
		auditorios = new Auditorium[8];
		eventos = new ArrayList<Event>();
	}
	public String addEvent(String name, String date, int startTime, int finishTime, String nameTeacher, String faculty,int totalPeople,int[]usados) {
		Event objEv = new Event(name,date,startTime,finishTime,nameTeacher,faculty,totalPeople,usados);
		objEv.usoAuditorium(this.auditorios);
		eventos.add(objEv);
		String msg = "Event registered sucessfully";
		return msg;
	}
	public String DeleteEvent(String name) {
		String msg = "The event doesn't exist";
		boolean val = false;
		for(int i = 0;i<eventos.size() && !val;i++) {
			if(eventos.get(i).getName().equalsIgnoreCase(name)) {
				eventos.remove(i);
				val= true;
				msg="The event "+name+" has been deleted\n";			
			}
		}
		return msg;
	}
	public String showEvent() {
		String msg = "";
		LocalDate today = LocalDate.now();
		LocalDate next5 = today.plusDays(5);
		for(int i =0;i<eventos.size();i++) {
			LocalDate eventDate = LocalDate.parse(eventos.get(i).getDate());
			if(eventDate.isAfter(today) && eventDate.isBefore(next5)) {
				msg+=eventos.get(i).toString();
			}
		}
		return msg;
	}
	public String addAuditorium(String name, String ubication, String status,int row,int column,int []columns) {
		String msg = "";
		boolean val = false;
		Auditorium obj = new Auditorium(name,ubication,status,row,column,columns);
		obj.createChair();
		for(int i =0;i<auditorios.length && !val;i++) {
			if(auditorios[i]==null) {
				auditorios[i]=obj;
				val =true;
				msg="Auditorium registered successfully\n";   
			}
		}
		return msg;
	}

	public String listAuditorium(){
		boolean val = false;
		String msg= "";
		for (int i =0;i<auditorios.length && !val ;i++ ) {
			if (auditorios[i]!=null) {
				String num = String.valueOf(i+1);
				msg+=num+". "+auditorios[i].getName()+ "\n";
			}
			else{
				val=true;
			}
		}
		return msg;
	}

	public boolean notRegister(){
		boolean val = false;
		if(auditorios[0]!=null){
			val=true;
		}
		return val;
	}

	public Event buscarEvent(String name){
		boolean val = false;
		Event obj = null;
		for (int i =0;i<eventos.size() && !val ;i++ ) {
			if(eventos.get(i).getName().equalsIgnoreCase(name)){
				obj=eventos.get(i);
				val=true;
			}
		}
		return obj;
	}

	public Auditorium buscarAuditorium(String name){
		boolean val =false;
		Auditorium obj = null;
		for (int i =0;i<auditorios.length && !val ;i++ ) {
			if(auditorios[i]!=null){
				if(auditorios[i].getName().equalsIgnoreCase(name)){
					obj=auditorios[i];
					val=true;
				}
			}
			else{
				val=true;
			}
		}
		return obj;
	}

	public String reportChair(String code,String desc,String name,String audi){
		String msg = "Error: the event doesn't exist";
		boolean val = false;
		for (int i =0;i<eventos.size() && !val ;i++ ) {
			if(eventos.get(i).getName().equalsIgnoreCase(name)){
				msg= eventos.get(i).reportChair(code,desc,audi);
				val = true;
			}
		}
		return msg;
	}
	public String showChairEvent(String name,String audi){
		String msg="Error: the event doesn't exist\n";
		for (int i=0;i<eventos.size() ;i++ ) {
			if(eventos.get(i).equalsIgnoreCase(name)){
				msg=event.get(i).showChairEvent();
			}
		}
		return msg;

	}
}
