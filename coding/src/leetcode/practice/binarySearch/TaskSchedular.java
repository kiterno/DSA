//package leetcode.practice.binarySearch;
//
//import java.util.PrimitiveIterator;
//import java.util.PriorityQueue;
//
//public class TaskSchedular {
//    public int leastInterval(char[] tasks, int n) {
//        PriorityQueue<Task> pq = new PriorityQueue<>();
//
//        char[] ch = new char[26];
//        for(char c: tasks) {
//            ch[c-'A'] ++;
//        }
//
//        for (int i = 0; i < 26; i++) {
//            pq.add(new Task((char) ('A'+i), ch[i]));
//        }
//
//        int count = 0;
//
//        while (pq.peek().value > 0) {
//            int c = 0;
//
//            for (Task task: pq) {
//                if (task.value == 0 || c>n) {
//                    break;
//                }
//                c++;
//                task.value--;
//            }
//
//
//        }
//    }
//
//    class Task {
//        char ch;
//        int value;
//
//        public Task(char ch, int value) {
//            this.ch = ch;
//            this.value = value;
//        }
//    }
//
//}
//
