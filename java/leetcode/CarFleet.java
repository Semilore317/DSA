// LeetCode #853 - Car Fleet

import java.util.Arrays;

/*
853. Car Fleet

There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
Return the number of car fleets that will arrive at the destination.

*/
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][target + 1];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));

        int count = 0;
        double prevTime = 0;
        for(double[] car : cars) {
            if(car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        CarFleet obj = new CarFleet();
        System.out.println(obj.carFleet(target, position, speed));
    }
}
