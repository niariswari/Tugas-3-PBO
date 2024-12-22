import java.util.List;

public abstract class Animal {
    protected boolean alive;
    protected Field field;
    protected Location location;

    public Animal(Field field, Location location) {
        alive = true;
        this.field = field;
        this.location = location;
        field.place(this, location);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        field.clear(location);
    }

    public abstract void act(List<Animal> newAnimals);
}
