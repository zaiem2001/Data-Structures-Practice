package Java.AtoZ.Greedy;

import java.util.Arrays;

public class JobScheduling {
    static int[] jobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int jobs = 0;
        int maxProfit = 0;
        int maxDeadline = -1;

        for (Job j : arr) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        int[] hash = new int[maxDeadline + 1];
        Arrays.fill(hash, -1);

        for (int i = 0; i < arr.length; i++) {
            Job currJob = arr[i];

            for (int j = currJob.deadline; j > 0; j--) {
                if (hash[j] == -1) {
                    hash[j] = currJob.id;
                    jobs++;
                    maxProfit += currJob.profit;
                    break;
                }
            }
        }

        return new int[] { jobs, maxProfit };
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[] {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25), new Job(5, 1, 15) };

        System.out.println(Arrays.toString(jobScheduling(jobs, jobs.length)));
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.deadline + " - " + this.profit;
    }
}