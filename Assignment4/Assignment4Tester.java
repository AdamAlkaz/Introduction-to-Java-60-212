public class Assignment4Tester {
	public static void main(String args[]){

		//make managers and workers

		Manager M1 = new Manager ("Michael Jay Scott", "15/7/2004",70000);

		NewWorker w1 = new NewWorker("Kevin Malone", "18/02/2011");
		NewWorker w2 = new NewWorker("Jim Halpert","15/06/2009",40000);
		NewWorker w3 = new NewWorker ("Pam Beesly", "17/01/2013",40000);

		Manager M2 = new Manager ("Dwight Schrute", "21/5/2010");

		NewWorker w4 = new NewWorker ("Toby Flenderson", "01/11/2012",45000);
		NewWorker w5 = new NewWorker ("Darryl Philbin", "30/07/2010",30000);
		NewWorker w6 = new NewWorker ("Angela Martin", "16/12/2013", 35000);

		//setSalary works for NewWorker and Manager
		w1.setSalary(30000);
		M2.setSalary(60000);

		//setSupervisor uses addWorker method of Manager
		w1.setSupervisor(M2);
		w2.setSupervisor(M1);
		w3.setSupervisor(M2);
		w4.setSupervisor(M1);
		w5.setSupervisor(M2);
		w6.setSupervisor(M1);
		M2.setSupervisor(M1);

		System.out.println(M1.toString() + "\n" + M2.toString());
		//deleteWorker uses equals method of NewWorker
		M2.deleteWorker(w3);
		w3.setSupervisor(M1);


		//check toString methods
		System.out.println(M1.toString() + "\n" + M2.toString() + "\n" + w3.toString());
	}
}
