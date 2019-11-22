package ui;
import model.*;
import java.util.*;
public class Main {
	University objUni;
	public Main() {
		objUni = new University("Icesi");
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		Main obj = new Main();
		boolean val = true;
		int option;
		while(val==true) {
			obj.showMenu();
			option= teclado2.nextInt();
			switch(option) {
			case 1:
				obj.createEvent();
				break;
			case 2:
				obj.createAuditorium();
				break;
			case 3:
				System.out.println("Enter the name of the event that you want to delete\n");
				String nam= teclado.nextLine();
				obj.deleteEvent(nam);
				break;
			case 4:
				obj.showEvent();
				break;
			case 5:
				val = false;
				break;
			default:
				System.out.println("Error: Wrong option\n");

			}
		}
		
	
		
	}

	public void createEvent() {
		boolean val = true;
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		while(val==true){
			if(objUni.notRegister()){

			}
			else{
				System.out.println("Error: You haven't registered auditoriums yet");
				val =false;
				break;
			}	
		System.out.println("Please enter the name of the event\n");
		String name = teclado.nextLine();
		System.out.println("Please enter the date of the event. Here is an example to help you out (YYYY-MM-DD)\n");
		String date = teclado.nextLine();
		System.out.println("Please enter the start time of the event. Without minutes\nRemember the university is open just between 7 to 20\n");
		int startTime = teclado2.nextInt();
		if(startTime<7 || startTime>20){
			System.out.println("Error: the hour exceed the schedule of the unversity\n");
			val=false;
			break;
		}
		System.out.println("Please enter the finish time of the event. Without minutes\nRemember the university is open just between 7 to 20\n");
		int finishTime = teclado2.nextInt();
		if(finishTime<7 || finishTime>20){
			System.out.println("Error: the hour exceed the schedule of the unversity\n");
			val=false;
			break;
		}
		if(((finishTime)-(startTime))<2 || ((finishTime)-(startTime))>12){
			System.out.println("Error: the duration of the event cannot be less than 2 hours or more than 12 hours\n");
			val=false;
			break;
		}
		System.out.println("Please enter the name of the teacher responsible of the event\n");
		String nameTeacher = teclado.nextLine();
		System.out.println("Please enter the name of the faculty\n");
		String faculty = teclado.nextLine();
		System.out.println("Please enter the number of attendees to the event\n");
		int totalPeople = teclado2.nextInt();
		System.out.println("How many auditoriums will this event use.Here is a list to help you out\n");
		System.out.println(objUni.listAuditorium());
		int cant =teclado2.nextInt();
		int usados []=new int[cant];
		for (int i=0;i<usados.length ;i++ ) {
			System.out.println("Enter the number of the auditorium\n");
			usados[i]=teclado2.nextInt();
		}
		System.out.println(objUni.addEvent(name, date, startTime, finishTime, nameTeacher, faculty, totalPeople,usados));
		val=false;	
	}
}
	public void createAuditorium() {
		Scanner teclado = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Please enter the name of the auditorium\n");
		String name = teclado.nextLine();
		System.out.println("Please enter the ubication of the auditorium \n");
		String ubication = teclado.nextLine();
		System.out.println("Please enter the number of rows of the auditorium\n");
		int rows = teclado2.nextInt();
		if(rows>26) {
			System.out.println("Error:exceeded number of rows\n");
		}
		else {
			int columns []=new int [rows];
			for(int i=0;i<columns.length;i++) {
				System.out.println("Please enter the number of chairs of the row number "+ (i+1)+"\n");
				columns[i]= teclado2.nextInt();
			}
			int numMayor = columns[0];
			for(int j =0;j<columns.length;j++) {
				if(columns[j]>numMayor) {
					numMayor=columns[j];
				}
			}
			
			System.out.println(objUni.addAuditorium(name,ubication,Auditorium.DISPONIBLE,rows,numMayor,columns));
			
		}
		
	}
	public void deleteEvent(String n) {
		System.out.println(objUni.DeleteEvent(n));
	}
	public void showMenu() {
		System.out.println("Select one option\n");
		System.out.println("Enter <1> to add a event\n");
		System.out.println("Enter <2> to add an auditorium\n");
		System.out.println("Enter <3> to delete a event\n");
		System.out.println("Enter <4> to show the events in the next 5 days\n");
		System.out.println("Enter <5> to exit\n");
	}
	public void showEvent() {
		System.out.println(objUni.showEvent());

	}
	public void reportChair(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Enter the name of the event\n");
		String name = teclado.nextLine();
		System.out.println("Enter the name of the auditorium");
		String audi = teclado.nextLine();
		System.out.println("Enter the code of the chair. For example <A3>\n");
		String code = teclado.nextLine();
		System.out.println("Please type a description of the chair\n");
		String desc = teclado.nextLine();
		System.out.println(objUni.reportChair(code,desc,name,audi)); 
		
	}


}
