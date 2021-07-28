package AlgoExpert.Easy;

import java.util.ArrayList;
import java.util.List;

class DFS {
    String name;
    List<DFS> children = new ArrayList<>();

    public DFS(String name) {
        this.name = name;
    }

    public List<String> depthFirstSearch(List<String> array) {

        array.add(this.name);
        System.out.println("size " + children.size() + "   " + children.hashCode());

        for (int i = 0; i < children.size(); i++) {
            System.out.println(i + "    " + children.get(i).name);
            System.out.println(children.get(i).depthFirstSearch(array).toString());
        }
        return array;
    }

    public DFS addChild(String name) {
        DFS child = new DFS(name);
        children.add(child);
        System.out.println("add child  " + children.hashCode() + "  " + children.size());
        return this;
    }


}