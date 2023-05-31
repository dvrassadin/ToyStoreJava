import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.PriorityQueue;

public class ToyStore {
    private String[] toy1;
    private String[] toy2;
    private String[] toy3;
    private PriorityQueue<Toy> toys = new PriorityQueue<>();

    public ToyStore(String toy1, String toy2, String toy3) {
        this.toy1 = toy1.split(" ");
        this.toy2 = toy2.split(" ");
        this.toy3 = toy3.split(" ");
    }

    public void fillToys(int number) {
        try {
            Toy[] toys = {
                    new Toy(Integer.parseInt(this.toy1[0]), Integer.parseInt(this.toy1[1]), this.toy1[2]),
                    new Toy(Integer.parseInt(this.toy2[0]), Integer.parseInt(this.toy2[1]), this.toy2[2]),
                    new Toy(Integer.parseInt(this.toy3[0]), Integer.parseInt(this.toy3[1]), this.toy3[2]) };

            int sumWeight = 0;
            for (Toy toy : toys)
                sumWeight += toy.getWeight();

            for (Toy toy : toys) {
                int numberOfThisToy = (int) Math.round((double) toy.getWeight() / (double) sumWeight * (double) number);
                for (int i = 0; i < numberOfThisToy; i++)
                    this.toys.add(new Toy(toy));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void writeToFile(String str) {
        try {
            Files.write(Paths.get("toys.txt"), str.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public Toy get() {
        Toy toy = this.toys.remove();
        this.writeToFile(toy.toString() + "\n");
        return toy;
    }
}
