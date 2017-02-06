import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scheduling {
	protected String name;
	protected double quantumTime;
	protected int processCount;
	protected double avgWaitingTime = 0;
	protected double avgCompleteTime = 0;
	protected double avgResponseTime = 0;
	protected static double runTime = 0;
	protected ArrayList<Process> waitingQueue = new ArrayList<Process>();
	protected ArrayList<Process> readyQueue = new ArrayList<Process>();
	protected ArrayList<Process> finishedProcesses = new ArrayList<Process>();

	public ArrayList<Process> getFinishedProcesses() {
		return finishedProcesses;
	}

	public void setFinishedProcesses(ArrayList<Process> finishedProcesses) {
		this.finishedProcesses = finishedProcesses;
	}

	public ArrayList<Process> getReadyQueue() {
		return readyQueue;
	}

	public void setReadyQueue(ArrayList<Process> readyQueue) {
		this.readyQueue = readyQueue;
	}

	public int getProcessCount() {
		return processCount;
	}

	public void setProcessCount(int processCount) {
		this.processCount = processCount;
	}

	public ArrayList<Process> getWaitingQueue() {
		return waitingQueue;
	}

	public void setWaitingQueue(ArrayList<Process> queue) {
		this.waitingQueue = queue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantumTime() {
		return quantumTime;
	}

	public void setQuantumTime(double quantumTime) {
		this.quantumTime = quantumTime;
	}

	public void readData(String fileName) throws IOException  {
		File f = new File(fileName);
		FileReader reader = new FileReader(f);
		Scanner in = new Scanner(reader);
		this.name = in.nextLine();
		this.processCount = Integer.parseInt(in.nextLine());
		if (this.name.equalsIgnoreCase("RR"))
			this.quantumTime = Double.parseDouble(in.nextLine());
		else
			in.nextLine();
		String line = null;
		while (in.hasNextLine()) {
			line = in.nextLine();
			if (line.trim() != "") {
				String[] item = line.split(";");
				String id = item[0];
				double arrivalTime = Double.parseDouble((item[1]));
				double burstTime = Double.parseDouble((item[2]));
				int priority = Integer.parseInt(item[3]);
				waitingQueue.add(new Process(id, arrivalTime, burstTime, priority));
			}
		}
		reader.close();
		in.close();
	}

	public void run() {
		System.out.println("CPU  Scheduling ");
	}

	public String getProcessChart() {
		return "Process Chart";
	}

	public String getTimeChart() {
		return "Time Chart";
	}

	public String printAvgTime() {
		for (Process p : finishedProcesses) {
			avgWaitingTime += p.getWaitingTime();
			avgCompleteTime += p.getCompleteTime();
			avgResponseTime += p.getResponseTime();
		}
		avgWaitingTime = (double) Math.round(((avgWaitingTime / processCount) * 100)) / 100;
		avgCompleteTime = (double) Math.round(((avgCompleteTime / processCount) * 100)) / 100;
		avgResponseTime = (double) Math.round(((avgResponseTime / processCount) * 100)) / 100;
		return avgWaitingTime + "|" + avgCompleteTime + "|" + avgResponseTime;
	}

	public String printProcessTime(Process p) {
		return p.getWaitingTime() + "|" + p.getCompleteTime() + "|" + p.getResponseTime();
	}

	public void writeResult(String fileName) throws IOException {
		File f = new File(fileName);
		FileWriter writer = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(writer);
		String s = null;

		s = getProcessChart();
		bw.write(s);
		bw.newLine();

		s = getTimeChart();
		bw.write(s);
		bw.newLine();

		for (Process p : finishedProcesses) {
			s = printProcessTime(p);
			bw.write(s);
			bw.newLine();
		}

		s = printAvgTime();
		bw.write(s);
		bw.flush();
		writer.close();
		bw.close();
	}
}
