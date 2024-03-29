package API;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Google");
        list.add("Apple");
        list.add("Microsoft");
        list.add("Facebook");
        Comparator<String> com = (String o1, String o2) -> o1.compareTo(o2);
        Collections.sort(list);
        for(String name:list){
            System.out.println(name);
        }
    }
}
