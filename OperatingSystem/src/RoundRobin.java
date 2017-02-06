import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoundRobin extends Scheduling {
	private ArrayList<Process> executedQueue = new ArrayList<Process>();

	public ArrayList<Process> getFinishedQueue() {
		return executedQueue;
	}

	public void setFinishedQueue(ArrayList<Process> finishedQueue) {
		this.executedQueue = finishedQueue;
	}

	public void checkReadyQueue(Process p) {
		if (!waitingQueue.isEmpty()) {
			if (readyQueue.isEmpty()) {
				if (p == null && runTime < waitingQueue.get(0).getArrivalTime()) {
					Process temp = new Process();
					temp.setId(" ");
					temp.setStartTime(runTime);
					temp.setFinishedTime(waitingQueue.get(0).getArrivalTime());
					executedQueue.add(temp);
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
		if (p != null) {
			readyQueue.add(p);
		}
	}

	@Override
	public void run() {
		Collections.sort(waitingQueue);
		Map<String, Double> burstTimeSave = new HashMap<String, Double>();
		for (Process p : waitingQueue) {
			burstTimeSave.put(p.getId(), p.getBurstTime());
		}
		checkReadyQueue(null);
		while (!readyQueue.isEmpty() || !waitingQueue.isEmpty()) {
			Process process = readyQueue.get(0);
			if (process.getBurstTime() > quantumTime) {
				Process temp = new Process();
				temp.setId(process.getId());
				temp.setStartTime(runTime);
				temp.setFinishedTime(runTime + quantumTime);
				executedQueue.add(temp);
				if (process.getArrivalTime() == 0) {
					process.setStartTime(0);
				} else if (process.getStartTime() <= 0)
					process.setStartTime(runTime);
				process.setBurstTime(process.getBurstTime() - quantumTime);
				runTime += quantumTime;
				readyQueue.remove(0);
				checkReadyQueue(process);
			} else {
				Process finish = new Process();
				finish.setId(process.getId());
				finish.setStartTime(runTime);
				if (process.getArrivalTime() == 0)
					process.setStartTime(0);
				else if (process.getStartTime() <= 0)
					process.setStartTime(runTime);
				runTime += process.getBurstTime();
				process.setFinishedTime(runTime);
				finish.setFinishedTime(runTime);
				executedQueue.add(finish);
				finishedProcesses.add(process);
				readyQueue.remove(0);
				checkReadyQueue(null);
			}
		}

		for (int j = 0; j < processCount; j++) {

			finishedProcesses.get(j).setCompleteTime(
					finishedProcesses.get(j).getFinishedTime() - finishedProcesses.get(j).getArrivalTime());
			finishedProcesses.get(j).setResponseTime(
					finishedProcesses.get(j).getStartTime() - finishedProcesses.get(j).getArrivalTime());
			finishedProcesses.get(j).setWaitingTime(
					finishedProcesses.get(j).getCompleteTime() - burstTimeSave.get(finishedProcesses.get(j).getId()));
		}
	}

	@Override
	public String getProcessChart() {
		String s = "|";
		for (Process p : executedQueue) {
			s += p.getId() + "|";
		}
		return s;
	}

	@Override
	public String getTimeChart() {
		String s = "|";
		for (Process p : executedQueue) {
			s += p.getStartTime() + "|";
		}
		s += executedQueue.get(executedQueue.size() - 1).getFinishedTime() + "|";
		return s;
	}

	@Override
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
}
