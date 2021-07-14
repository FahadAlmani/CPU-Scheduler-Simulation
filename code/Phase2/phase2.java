package Phase2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class phase2 {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Fahad\\eclipse-workspace\\CSC227Project\\src\\Phase2//test.csv";
		String line = "";
		BufferedReader read = new BufferedReader(new FileReader(path));
		PriorityQueue<PCB> tmpQueue = new PriorityQueue<PCB>();
		// read csv file
		read.readLine();
		while ((line = read.readLine()) != null) {
			String[] data = line.split(",");
			tmpQueue.add(new PCB(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
		}
		read.close();
		// extract output
		int first = 0;
		int secondExecuted = 0;
		int lastExecuted = 0;
		ArrayList<PCB> termneted = new ArrayList<PCB>();
		PriorityQueue<PCB> ReadyQueue = new PriorityQueue<PCB>();
		while (!tmpQueue.isEmpty()) {
			PCB tmp = tmpQueue.poll();
			if (ReadyQueue.isEmpty())
				first = tmp.ArivalTime;
			if (ReadyQueue.size() == 1)
				secondExecuted = tmp.PID;
			lastExecuted = tmp.PID;
			ReadyQueue.add(tmp);
		}
		int quantum = 3;
		int totalburst = 0;
		PCB process = null;
		int burst = 0;
		while (!ReadyQueue.isEmpty()) {
			burst = 0;
			process = ReadyQueue.poll();
			for (int i = 0; i < quantum; i++) {
				burst++;
				totalburst++;
				process.ChangableBurstTime--;
				if (process.ChangableBurstTime == 0) {
					process.State = "terminated";
					PCB.TotalWaitingtime += burst * (ReadyQueue.size());
					process.WaitingTime = totalburst - process.WaitingTime - process.RealBurstTime;
					process.Turnaroundtime += totalburst;
					PCB.TotalTurnaroundtime += process.Turnaroundtime;
					process.FinishTime = totalburst;
					termneted.add(process);
					break;
				}
				if (i == quantum - 1) {
					PCB.TotalWaitingtime += burst * (ReadyQueue.size());
					process.ArivalTime = totalburst;
					process.ContextSwitch++;
					ReadyQueue.add(process);
				}

			}
		}
		// print output
		System.out.println("Time the first process arrives: " + first);
		System.out.println("PID of the second process executed: " + secondExecuted);
		System.out.println("Time the last process executed: " + (process.FinishTime - burst));
		System.out.println("PID of the last process executed: " + lastExecuted);
		System.out.println("Total time for execution of all processes: " + totalburst); // no sure
		System.out.println("Average turnaround time: " + (double) PCB.TotalTurnaroundtime / termneted.size());
		System.out.println("Average waiting time: " + ((double) PCB.TotalWaitingtime / termneted.size()));
		System.out.println("Finish time of every process: ");
		System.out.println("PID\tFinish time");
		for (int i = 0; i < termneted.size(); i++) {
			System.out.print(termneted.get(i).PID + "\t     ");
			System.out.println(termneted.get(i).FinishTime);
		}
	}

}
