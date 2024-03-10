package leetcode.practice.dsu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    Map<String, String> parents = new HashMap<>();
    Map<String, Double> vals = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        for(int i = 0; i < equations.size(); i++){
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            union(x, y, values[i]);
        }
        System.out.println(parents);
        System.out.println(vals);
        for(int i = 0; i < queries.size(); i++){
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            res[i] = (parents.containsKey(x) && parents.containsKey(y) && find(x) == find(y) ? vals.get(x) / vals.get(y) : -1.0);
            System.out.println(parents);
            System.out.println(vals);
        }

        System.out.println(parents);
        System.out.println(vals);
        return res;
    }

    public void add(String x){
        if(parents.containsKey(x)){
            return;
        }
        parents.put(x,x);
        vals.put(x, 1.0);
    }

    public String find(String x){
        String p = parents.getOrDefault(x, x);
        if(x != p){
            String pp = find(p);
            vals.put(x, vals.get(x) * vals.get(p));
            parents.put(x, pp);
        }
        return parents.getOrDefault(x,x);
    }

    public void union(String x, String y, double v){
        add(x);
        add(y);
        String vx = find(x), vy = find(y);
        parents.put(vx, vy);
        vals.put(vx, v * vals.get(y) / vals.get(x));
    }

    public static void main(String[] args) {
        List<List<String>> parent = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));

        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(parent, values, queries)));
    }
}
