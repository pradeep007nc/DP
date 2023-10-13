package prac.Comparator;

import java.util.*;

public class PracTreeMap {
    public static void main(String[] args) {
        List<DemoObject> list = new ArrayList<>();
        list.add(new DemoObject("1", "pradeep"));
        list.add(new DemoObject("2", "pradeep"));
        list.add(new DemoObject("43", "pradeep"));
        list.add(new DemoObject("22", "pradeep"));
        list.add(new DemoObject("11", "pradeep"));

        list.sort(Comparator.comparing(DemoObject::getId));

        list.forEach((data) -> System.out.println(data.id+" "+data.name));
        System.out.println();

        Map<String, DemoObject> map = new HashMap<>();
        map.put("12", new DemoObject("1", "pradeep"));
        map.put("22", new DemoObject("21", "pradeep"));
        map.put("1", new DemoObject("3", "pradeep"));
        map.put("11", new DemoObject("31", "pradeep"));
        map.put("3", new DemoObject("12", "pradeep"));

        SortedMap<String, DemoObject> map1 = new TreeMap<>(map);

        map1.forEach((key, value) -> System.out.println(key+" "+ value.id+" "+value.name));
        System.out.println();

        List<Map.Entry<String, DemoObject>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Comparator.comparing((data) -> data.getValue().getId()));
        entryList.forEach((key) -> System.out.println(key.getValue().id+" "+key.getValue().name));

        System.out.println();
        map.forEach((key, value) -> System.out.println(key+" "+ value.id+" "+value.name));
    }
}

class DemoObject{

    String id;
    String name;

    public DemoObject(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }
}
