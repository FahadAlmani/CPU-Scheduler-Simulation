package Phase1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class phase1 {

	public static void main(String[] args) throws IOException {
		String path ="data for students 01 ver2.csv";
		int process = 0;
		int maxburst = Integer.MIN_VALUE;
		int minburst = Integer.MAX_VALUE;
		int timeburst =0;
		ArrayList<Integer> alltimeburst= new ArrayList<Integer>();
		String line="";
		BufferedReader read = new BufferedReader(new FileReader(path));
		while((line = read.readLine()) !=null) {
			process++;
			String[] temp=line.split(",");
			alltimeburst.add(Integer.parseInt(temp[1]));
			timeburst += Integer.parseInt(temp[1]);
			if(Integer.parseInt(temp[1])>maxburst)
			maxburst= Integer.parseInt(temp[1]);
			if(Integer.parseInt(temp[1])<minburst)
				minburst= Integer.parseInt(temp[1]);
		}
		read.close();
		double avgtimeburst = (double) timeburst / process;
		int maxavg = 0;
		int minavg = 0;
		for(int i = 0; i<alltimeburst.size();i++) {
			if(alltimeburst.get(i)>avgtimeburst)
				maxavg++;
			else if(alltimeburst.get(i)<avgtimeburst)
				minavg++;
		}
		System.out.println("Total number of process: "+process);
		System.out.println("Maximum burst time: "+maxburst);
		System.out.println("Minimum burst time: "+minburst);
		System.out.println("How many process have more than average burst time: "+maxavg);
		System.out.println("How many processes have less than average burst time: "+minavg);
	}

}
