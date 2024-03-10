package medium;

import java.util.*;

public class PiramalTest {

    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();

        Map<Integer, List<String>> entry = new HashMap<>();

        for (int i = 0; i < schedules.size(); i++) {
            List<String> list = entry.getOrDefault(schedules.get(i).start, new ArrayList<>());
            list.add(schedules.get(i).id);

            entry.put(schedules.get(i).start, list);
        }

        Map<Integer, List<String>> exit = new HashMap<>();

        for (int i = 0; i < schedules.size(); i++) {
            List<String> list = exit.getOrDefault(schedules.get(i).end, new ArrayList<>());
            list.add(schedules.get(i).id);

            exit.put(schedules.get(i).end, list);
        }

        int k=0;

        int[] time = new int[schedules.size()*2];
        for (Schedule schedule: schedules) {
            time[k++] = schedule.start;
            time[k++] = schedule.end;
        }

        Arrays.sort(time);

        Set<String> resultSet = new HashSet<>();
        for (int i=1;i<k;i++) {

            if (entry.containsKey(time[i-1]) ) {
                resultSet.addAll(entry.get(time[i-1]));
            }

            System.out.println(time[i-1] +" " + time[i] + " " + resultSet);

            if (exit.containsKey(time[i])) {
                resultSet.removeAll(exit.get(time[i]));
            }
        }
    }


    static class Schedule {
        int start, end;
        String id;

        Schedule(int start, int end, String id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }
}

/*
Map Entry -> 10 , Dheere
Map Exit -> 50 , Dheerendra


10, 50, 'Dheerendra'
10, 30,
20, 30, 'Vishal'
25, 35, 'Kaushal'
40, 55, 'Akash'

<(10, (0, 0)), (x, (

n -> 2n -> nlog(n) + Entry n + Exit n + 2n -> nlog(n)

10 - 20 ->
20 - 25 ->

10, 20, 25, 30, 35, 40, 50, 55

10, 20 -> Dheerendra
20, 25 -> Dheerendra Vishal
25, 30 -> Dheerendra Vishal Kaushal
30, 35 -> Dheerendra Kaushal
35, 40 -> Dheerendra
40, 50 -> Dheerendra Akash
50, 55 -> Akash


Result Map -> Dheerendra, Vishal, kaushal -> PrintResult -> Dheerendra, kaushal
 */


/*
List<Inputs>
key value ->

Stream of this key, value ->

Time Complexity :

/insert -> (key, value) -> log(n) + n -> O(n)
/delete -> (key) -> delete if key present -> O(n)
/getLatest ->  9 -> O(1)
/getLargest -> 10 -> O(1)
/getOldest -> 4 -> O(1)
/getSmallest -> 5 -> O(1)


4, 5
9, 10
4, 15
8, 10

/delete - 9, 10

List -> <4, 9, 8>
MaxHeap -> PQ -> Value
MINHeap -> PQ -> value
Map<key, value>

{
4 = 5 <> 15
9 = 10
8 = 10
}

list = [4, 9]
minHeap -> 5, 10
maxHeap -> 10, 5


Queue -> oldest
Queue -> latest

 */