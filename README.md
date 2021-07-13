# CPU-Scheduler-Simulation
# Project Description:
  In this project you will simulate Round Robin scheduling algorithm. For the sake of simulation, consider a
  simple system with a single CPU, single I/O device. The CPU has a ready queue and an I/O queue. The 
  system will select a process from the ready queue based on RR algorithm (quantum time will be given to 
  you) and send it to CPU. Information about a process is maintained in process control block (PCB) during 
  the lifetime of the process i.e. from start until termination. Each process PCB contains all required 
  information to identify the process such as its id, its state, and required statistics which include 
  turnaround time for each process, and waiting time for each process. You can add
# Phase1:
  You will write Java program to read the file (of standard data format) and produce some statistics. This phase is to make sure that everyone uses the same data file format.
 
 Statistics required in this phase are:
  1.	Total number of process.
  2.	Maximum burst time
  3.	Minimum burst time
  4.	How many process have more than average burst time?
  5.	How many processes have less than average burst time?
# Phase2:
  New data file (of standard format) will be provided to every student i.e. every member of group which he will use to simulate his project and then submit the result. Statistics   
  required in this phase are:
  1.	Time the first process arrives.
  2.	PID of the second process executed. 
  3.	Time the last process executed.
  4.	PID of the last process executed.
  5.	Finish time of every process.
  6.	Total time for execution of all processes.
  7.	Average turnaround time.
  8.	Average waiting time.
