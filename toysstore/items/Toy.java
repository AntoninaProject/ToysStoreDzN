package toysstore.items;

public class Toy implements Lotable {
    private int id;
    private String name;

    public Toy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "<" + id + "> " + name;
    }
}
