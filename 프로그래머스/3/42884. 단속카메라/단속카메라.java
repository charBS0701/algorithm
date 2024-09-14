import java.util.*;
class Solution {
    static int answer;
    static PriorityQueue<Car> cars = new PriorityQueue<>((o1,o2) -> o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s);
    static PriorityQueue<Car> inCars = new PriorityQueue<>((o1,o2) -> o1.e - o2.e);
    public int solution(int[][] routes) {
        for (int[] car : routes) {
            cars.add(new Car(car[0],car[1]));
        }
        
        while (!cars.isEmpty()) {
            Car car = cars.poll();
            
            if (!inCars.isEmpty()) {
                Car inCar = inCars.peek();
                if (car.s > inCar.e) {
                    answer++;
                    inCars.clear();
                }
            }
            inCars.add(car);
        }
        
        if (!inCars.isEmpty()) {
            answer++;
        }
        
        return answer;
    }
    
    static class Car {
        int s;
        int e;
        
        public Car(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}