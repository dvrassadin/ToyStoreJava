public class Toy implements Comparable<Toy> {
    private int id;
    private int weight;
    private String type;

    public Toy(int id, int weight, String type) {
        this.id = id;
        this.weight = weight;
        this.type = type;
    }

    public Toy(Toy another) {
        this.id = another.id;
        this.weight = another.weight;
        this.type = another.type;
    }

    public int getId() {
        return this.id;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.id + " " + this.weight + " " + this.type;
    }

    @Override
    public int compareTo(Toy o) {
        return o.weight - this.weight;
    }
}
