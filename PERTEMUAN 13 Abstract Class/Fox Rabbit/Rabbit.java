import java.util.List;

public class Rabbit extends Animal {
    public Rabbit(Field field, Location location) {
        super(field, location);
    }

    public void act(List<Animal> newAnimals) {
        if (!isAlive()) {
            return;
        }

        Location newLocation = findNewLocation();
        if (newLocation != null) {
            field.clear(location);
            location = newLocation;
            field.place(this, location);
        } else if (Math.random() < 0.2) {
            newAnimals.add(new Rabbit(field, location));
        }
    }

    private Location findNewLocation() {
        int newRow = location.getRow() + (int) (Math.random() * 3) - 1;
        int newCol = location.getCol() + (int) (Math.random() * 3) - 1;
        if (newRow >= 0 && newRow < field.getRows() && newCol >= 0 && newCol < field.getCols()) {
            return new Location(newRow, newCol);
        }
        return null;
    }
}
