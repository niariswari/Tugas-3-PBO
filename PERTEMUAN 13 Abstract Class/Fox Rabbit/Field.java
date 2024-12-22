public class Field {
    private Object[][] field;

    public Field(int rows, int cols) {
        field = new Object[rows][cols];
    }

    public int getRows() {
        return field.length;
    }

    public int getCols() {
        return field[0].length;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public void place(Object obj, Location location) {
        field[location.getRow()][location.getCol()] = obj;
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }
}
