import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Field field;
    private List<Animal> animals;
    private SimulatorView view;

    public Simulator(int rows, int cols) {
        field = new Field(rows, cols);
        animals = new ArrayList<>();
        view = new SimulatorView(field);
        populate();
    }

    public void run() {
        int steps = 5;
        for (int step = 0; step < steps; step++) {
            simulateOneStep();
            view.showStatus(step, field);
        }
    }

    private void simulateOneStep() {
        List<Animal> newAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            animal.act(newAnimals);
        }
        animals.addAll(newAnimals);
        animals.removeIf(animal -> !animal.isAlive());
    }

    private void populate() {
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {
                if (Math.random() < 0.1) {
                    Rabbit rabbit = new Rabbit(field, new Location(row, col));
                    animals.add(rabbit);
                } else if (Math.random() < 0.05) {
                    Fox fox = new Fox(field, new Location(row, col));
                    animals.add(fox);
                }
            }
        }
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator(20, 20);
        sim.run();
    }
}
