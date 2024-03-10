package design.pattern.iterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for(Iterator iterator = nameRepository.getIterator(); iterator.hasNext();){
            String name = (String) iterator.next();
            System.out.println(name);
        }

        List<Integer> number = Arrays.asList(2,3,4,5);
        List<String> names = Arrays.asList("Dheeru", "Akash");

        java.util.Iterator iterator = number.iterator();
        java.util.Iterator iterator1 = names.iterator();

        List<Integer> square = number.stream().map(x -> x*x).
                collect(Collectors.toList());

        List<Integer> dowble = number.stream().map(x -> x+x).collect(Collectors.toList());
        System.out.println(square + "\t" + dowble);
    }
}
