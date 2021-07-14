package Phase2;
public class PCB implements Comparable<PCB>{
public int PID;
public int RealBurstTime;
public int ArivalTime;
public String State;
public int Turnaroundtime;
public int WaitingTime;
public int ChangableBurstTime;
public int FinishTime;
public int ContextSwitch;
public static int TotalWaitingtime;
public static int TotalTurnaroundtime;
public PCB(int PID , int RealBurstTime , int ArivalTime) {
	this.PID = PID;
	this.RealBurstTime = RealBurstTime;
	this.ArivalTime = ArivalTime;
	this.State = "Ready";
	this.Turnaroundtime = ArivalTime * -1;
	this.ChangableBurstTime = RealBurstTime;
	this.WaitingTime = ArivalTime;
	PCB.TotalWaitingtime += WaitingTime * -1;
}

public int compareTo(PCB o) {
	 if(this.ArivalTime > o.ArivalTime)
		return 1;
	 else if(this.ArivalTime == o.ArivalTime) {
	 if(this.ContextSwitch > o.ContextSwitch)
		return 1;
	 else if(this.ContextSwitch == o.ContextSwitch)
	 if(this.PID > o.PID)
			return 1;
	 }
	return -1;
}
}