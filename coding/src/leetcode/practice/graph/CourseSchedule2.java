package leetcode.practice.graph;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new List[numCourses];
        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] i: prerequisites) {
            adj[i[0]].add(i[1]);
            indegree[i[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        int[] res = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            stack.push(curr);
            for(int neigh: adj[curr]) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        while (!stack.isEmpty()) {
            res[count++] = stack.pop();
        }

        return res;
    }
}
