package google.com.stack;

import java.util.Stack;

import static google.com.stack.StockSpanProblem.println;

public class AsteroidCollision {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<N;i++) {
            if (!stack.isEmpty() && asteroids[i]<0 && asteroids[i] == stack.peek() * -1) {
                stack.pop();
            } else if(stack.isEmpty() || (stack.peek()<0 && asteroids[i]>0)) {
                stack.push(asteroids[i]);
            } else {
                if((stack.peek() > 0 && asteroids[i] > 0) || (stack.peek() < 0 && asteroids[i] < 0)) {
                    stack.push(asteroids[i]);
                } else {
                    while (!stack.isEmpty() && asteroids[i] > 0 && stack.peek() < 0 && asteroids[i] >= stack.peek()*-1) {
                        stack.pop();
                    }
                    while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0 && asteroids[i] * -1 >= stack.peek()) {
                        stack.pop();
                    }
                    if(stack.isEmpty() || (stack.peek() > 0 && asteroids[i] > 0) || (stack.peek() < 0 && asteroids[i] < 0))
                        stack.push(asteroids[i]);
                }
            }
            System.out.println(stack);
        }

        int[] res = new int[stack.size()];
        for (int i=stack.size()-1;i>=0;i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] asteroids = {-5, 5, 2, 1, 1, -2 };
        int[] asteroids = {1, -7, -3, -12, 1, -8};

//        int[] asteroids = {3, 5, -3};
        int n=asteroids.length;

        int res[] = asteroidCollision(n, asteroids);

        println(res);
    }
}
