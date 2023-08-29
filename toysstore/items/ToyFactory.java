package toysstore.items;

public class ToyFactory {
    private static ToyFactory instance = null;
    private static int toyId = 0;

    public static ToyFactory createToyFactory() {
        if (instance == null) {
            instance = new ToyFactory();
        }
        return instance;
    }

    private ToyFactory() {}

    public Toy createToy(String name) {
        toyId += 1;
        return new Toy(toyId, name);
    }
}
