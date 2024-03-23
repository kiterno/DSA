package mac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        DSU dsu = new DSU();

        double[] result = new double[queries.size()];

        for(int i=0;i<equations.size(); i++) {
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            dsu.union(x, y, values[i]);
        }

        for(int i=0;i<queries.size(); i++) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);

            result[i] = (dsu.parent.containsKey(x) && dsu.parent.containsKey(y) && dsu.find(x) == dsu.find(y)) ? dsu.values.get(x) / dsu.values.get(y) : -1.0;


        }

        return result;
    }

    class DSU {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> values = new HashMap<>();

        public void add(String x) {
            if (parent.containsKey(x)) return;

            parent.put(x, x);
            values.put(x, 1.0);
        }

        public String find(String x) {
            String p = parent.getOrDefault(x, x);

            if (x != p) {
                String pp = find(p);
                values.put(x, values.get(x) * values.get(p));
                parent.put(x, pp);
            }

            return parent.getOrDefault(x, x);
        }

        public void union(String x, String y, double v) {
            add(x);
            add(y);

            String vx = find(x), vy = find(y);
            parent.put(vx, vy);
            values.put(vx, v * values.get(y) / values.get(x));
        }
    }
}
