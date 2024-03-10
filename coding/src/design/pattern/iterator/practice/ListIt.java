package design.pattern.iterator.practice;

import java.util.Iterator;
import java.util.List;

public class ListIt {

    public static void main(String[] args) {
        List<String> strings = List.of("Dheeru", "Bhai", "Dheere4ndra", "Choudhary");
        Iterator iterator = strings.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
