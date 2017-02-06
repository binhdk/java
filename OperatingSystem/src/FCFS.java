import java.util.Collections;

public class FCFS extends Scheduling {
	@Override
	public String getProcessChart() {
		String s = null;
		if (finishedProcesses.get(0).getStartTime() > 0)
			s = "| |" + finishedProcesses.get(0).getId();
		else
			s = "|" + finishedProcesses.get(0).getId();
		for (int i = 1; i < finishedProcesses.size(); i++) {
			if (finishedProcesses.get(i).getStartTime() > finishedProcesses.get(i - 1).getFinishedTime())
				s += "| |" + finishedProcesses.get(i).getId();
			else
				s += "|" + finishedProcesses.get(i).getId();
		}
		s += "|";
		return s;
	}

	@Override
	public String getTimeChart() {
		String s = null;
		if (finishedProcesses.get(0).getStartTime() > 0)
			s = "|0|" + finishedProcesses.get(0).getStartTime();
		else
			s = "|" + finishedProcesses.get(0).getStartTime();
		for (int i = 1; i < finishedProcesses.size(); i++) {
			if (finishedProcesses.get(i).getStartTime() > finishedProcesses.get(i - 1).getFinishedTime())
				s += "|" + finishedProcesses.get(i - 1).getFinishedTime() + "|"
						+ finishedProcesses.get(i).getStartTime();
			else
				s += "|" + finishedProcesses.get(i).getStartTime();
		}
		s += "|"+finishedProcesses.get(processCount-1).getFinishedTime()+"|";
		return s;
	}

	public void checkReadyQueue() {
		if (!waitingQueue.isEmpty()) {
			if (readyQueue.isEmpty()) {
				if (runTime < waitingQueue.get(0).getArrivalTime()) {
					runTime = waitingQueue.get(0).getArrivalTime();
				}
			}
			for (int i = 0; i < waitingQueue.size(); i++) {
				Process process = waitingQueue.get(i);
				if (runTime >= process.getArrivalTime()) {
					readyQueue.add(process);
					waitingQueue.remove(i);
					i--;
				}
			}
		}
	}

	@Override
	public void run() {
		Collections.sort(waitingQueue);
		checkReadyQueue();
		while (!readyQueue.isEmpty() || !waitingQueue.isEmpty()) {
			Process process = readyQueue.get(0);
			process.setStartTime(runTime);
			runTime += process.getBurstTime();
			process.setFinishedTime(runTime);
			finishedProcesses.add(process);
			readyQueue.remove(0);
			checkReadyQueue();
		}
		for (int j = 0; j < processCount; j++) {
			finishedProcesses.get(j).setWaitingTime(
					finishedProcesses.get(j).getStartTime() - finishedProcesses.get(j).getArrivalTime());
			finishedProcesses.get(j).setCompleteTime(
					finishedProcesses.get(j).getFinishedTime() - finishedProcesses.get(j).getArrivalTime());
			finishedProcesses.get(j).setResponseTime(
					finishedProcesses.get(j).getStartTime() - finishedProcesses.get(j).getArrivalTime());
		}
	}
}
