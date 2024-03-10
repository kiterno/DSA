package leetcode.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public  boolean canFinish(int numCourses, int[][] preRequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] adj = new List[numCourses];
        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] i: preRequisites) {
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

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for(int neigh: adj[curr]) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        return count == numCourses;
    }

}
