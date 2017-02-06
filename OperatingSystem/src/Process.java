
public class Process implements Comparable<Process> {
	private String id;
	private double arrivalTime;
	private double burstTime;
	private int priority;
	private double waitingTime;
	private double completeTime;
	private double responseTime;
	private double startTime;
	private double finishedTime;

	public Process(String id, double at, double bt, int prior) {
		this.id = id;
		arrivalTime = at;
		burstTime = bt;
		priority = prior;
	}

	public Process() {

	}

	public double getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(double finishedTime) {
		this.finishedTime = finishedTime;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(double waitingTime) {
		this.waitingTime = waitingTime;
	}

	public double getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(double completeTime) {
		this.completeTime = completeTime;
	}

	public double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(double burstTime) {
		this.burstTime = burstTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Process other) {
		if (arrivalTime > other.arrivalTime)
			return 1;
		else if (arrivalTime < other.arrivalTime)
			return -1;
		return 0;
	}
}
