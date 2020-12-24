package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		int totalWeight = 0;

		Queue<Truck> waitingQ = new LinkedList<>();
		Queue<Truck> runningQ = new LinkedList<>();

		Truck[] trucks = new Truck[truck_weights.length];

		for (int i=0; i<truck_weights.length; i++) {
			trucks[i] = new Truck(bridge_length, truck_weights[i]);
			waitingQ.add(trucks[i]);
		}

		totalWeight += waitingQ.peek().weight;
		runningQ.add(waitingQ.remove());

		while (!runningQ.isEmpty()) {
			for (Truck truck : runningQ) {
				truck.time--;
			}

			if (runningQ.peek().time <= 0) {
				totalWeight -= runningQ.remove().weight;
			}

			if (!waitingQ.isEmpty() && totalWeight + waitingQ.peek().weight <= weight ) {
				totalWeight += waitingQ.peek().weight;
				runningQ.add(waitingQ.remove());
			}

			time++;

		}

		return ++time; // 모든 트럭이 다리를 건너려면 몇 초?
	}
}

class Truck {
	int time;
	int weight;

	public Truck(int time, int weight) {
		this.time = time;
		this.weight = weight;
	}
}