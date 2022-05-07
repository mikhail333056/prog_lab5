package data;

import exceptions.IncorrectValueException;

/**
 * A class that implements work with storing the values of the coordinates of the location of persons in the collection
 */
public class Coordinates {
    private Integer x; //Максимальное значение поля: 749, Поле не может быть null
    private long y; //Значение поля должно быть больше -599
    Coordinates (final Coordinates coordinates) {
        x = coordinates.x;
        y = coordinates.y;
    }
    Coordinates () {}

    public void setX (final Integer x) throws IncorrectValueException {
        if (x >= 749)
            throw new IncorrectValueException("значение координаты x должно быть не больше 749");
        if (x == null)
            throw new IncorrectValueException("координата x не может быть пустым");
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public void setY (final long y) throws IncorrectValueException {
        if (y <= -599)
            throw new IncorrectValueException("значение координаты y должно быть больше -599");
        this.y = y;
    }

    public long getY() {
        return y;
    }

    @Override
    public String toString () {
        return "{\"x\" : " + Integer.toString(x) + ", \"y\" : " + Long.toString(y) + "}";
    }
}