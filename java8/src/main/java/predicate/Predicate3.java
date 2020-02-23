package predicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author ZhengH
 * @date 2020/2/20 11:30
 **/
public class Predicate3 {
    public static void main(String[] args) {
        List<Stuent> list = new ArrayList<>();
        list.add(new Stuent("1","1"));
        list.add(new Stuent("2","2"));
        list.add(new Stuent("3","2"));
        list.add(new Stuent("4","4"));
        list.add(new Stuent("5","4"));
        list.add(new Stuent("6","2"));
        list = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Stuent::getName))), ArrayList::new)
        );

        for (Stuent stuent : list) {
            System.out.println(stuent);
        }




    }

}

class Stuent{

    private String id;
    private String name;

    @Override
    public String toString() {
        return "Stuent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Stuent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
