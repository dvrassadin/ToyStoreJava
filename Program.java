public class Program {
    public static void main(String[] args) {
        int numberOfToys = 10;
        ToyStore toyStore = new ToyStore("1 2 constructor", "2 2 robot", "3 6 doll");

        try {
            toyStore.fillToys(numberOfToys);

            for (int i = 0; i < numberOfToys; i++)
                System.out.println(toyStore.get());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
