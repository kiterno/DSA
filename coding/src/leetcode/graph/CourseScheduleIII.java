package leetcode.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (temp1, temp2) -> temp1[1]-temp2[1]);

            int totalTime = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b-a);

            for(int[] course: courses) {
                totalTime += course[0];
                priorityQueue.add(course[0]);

                if (totalTime>course[1]) totalTime-=priorityQueue.poll();
            }

            return priorityQueue.size();
        }
}
