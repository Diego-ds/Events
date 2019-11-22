package model;

public class Auditorium {
	Chair sillas [][];
	private int [] columns;
	private String name;
	private String ubication;
	private String status;
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String RED = "\u001B[31m";
	public static final String DISPONIBLE = "Available";
	public static final String OCUPADO = "Occupied";
	//Constructor
	public Auditorium(String name, String ubication, String status,int row,int column,int []columns) {
		sillas = new Chair [row][column];
		this.columns=columns;
		this.name = name;
		this.ubication = ubication;
		this.status = status;
	}
	//Getters and setters
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public String getUbication() {
		return ubication;
	}

	public void createChair(){
		char [] abc = new char[26];
		for(int k =0;k<26;k++){
			abc[k]=(char)('A'+k);
		}
		boolean val = false;
		for(int i=0;i<sillas.length;i++){
			for(int j=0;j<sillas[0].length && j<columns[i];j++){
					String idSilla =String.valueOf(abc[i]) + String.valueOf(j+1);
					Chair obj = new Chair(Chair.OPERATIVA,idSilla);
					sillas[i][j]=obj;
			}
		}
	}
	
	public String reportChair(String code,String desc){
		boolean val = false;
		String msg = "Error: the chair doesn´t exist";
		for (int i =0;i<sillas.length && !val ;i++ ) {
			for (int j=0;j<sillas[0].length && !val ;j++ ) {
				if(sillas[i][j]!=null){
					if(sillas[i][j].getCode().equalsIgnoreCase(code)){
						sillas[i][j].setStatus(Chair.DEFECTUOSA);
						msg="Chair was sucessfully reported as deficient\n";
						val=true;
					}
				}	
			}
		}
		return msg;
	}

	public String showChairs(){
		boolean val = false;
		String msg = "";
		for (int i =0;i<sillas.length ;i++ ) {
			for (int j=0;j<sillas[0].length ;j++ ) {
				if(sillas[i][j]!=null){
					if(sillas[i][j].getStatus().equalsIgnoreCase(Chair.OPERATIVA)){
						msg+= Auditorium.GREEN+sillas[i][j].getCode();
					}
					else if(sillas[i][j].getStatus().equalsIgnoreCase(Chair.DEFECTUOSA)){
						msg+= Auditorium.RED+sillas[i][j].getCode();
					}
					else if(sillas[i][j].getStatus().equalsIgnoreCase(Auditorium.OCUPADO)){
						msg+= Auditorium.BLUE+sillas[i][j].getCode();
					}

				}
			}
		}
		return msg;
	}

	public void ocuparChair(){
		for (int i=0;i<sillas.length ;i++ ) {
			for (int j=0;j<sillas[0].length ;j++ ) {
				int filaAlea = (int)(Math.random()*sillas.length+1);
				int columAlea= (int)(Math.random()*sillas[0].length+1);
				if(sillas[filaAlea][columAlea]!=null){
					if(!sillas[filaAlea][columAlea].getStatus().equalsIgnoreCase(Chair.DEFECTUOSA)){
						sillas[filaAlea][columAlea].setStatus(Auditorium.OCUPADO);
					}					
				}
			}
		}
	}
	public void desocuparChair(){
		boolean val = false;
		for (int i=0;i<sillas.length && !val ;i++ ) {
			for (int j=0;j<sillas[0].length && !val ;j++ ) {
				if(sillas[i][j]!=null){
					if(!sillas[i][j].getStatus().equalsIgnoreCase(Chair.DEFECTUOSA)){
						sillas[i][j].setStatus(Chair.OPERATIVA);
					}
				}
			}
		}
	}
}
