public class SimulatorView {
    private Field field;

    public SimulatorView(Field field) {
        this.field = field;
    }

    public void showStatus(int step, Field field) {
        int rabbitCount = 0;
        int foxCount = 0;

        System.out.println("Step: " + step);
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {
                Object obj = field.getObjectAt(new Location(row, col));
                if (obj instanceof Rabbit) {
                    System.out.print("R ");
                    rabbitCount++;
                } else if (obj instanceof Fox) {
                    System.out.print("F ");
                    foxCount++;
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println("Rabbits: " + rabbitCount + " | Foxes: " + foxCount);
        System.out.println();
    }
}
