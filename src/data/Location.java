package data;

import exceptions.IncorrectValueException;

/**
 * A class that implements work with storing the values of the coordinates of the territory of the location of persons in the collection
 */
public class Location {
    private float x;
    private Float y; //Поле не может быть null
    private Long z; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле может быть null

    Location() {

    }

    Location (final Location location) {
        x = location.x;
        y = location.y;
        z = location.z;
        name = location.name;
    }

    public void setX (float x) {
        this.x = x;
    }

    public float getX () {
        return x;
    }

    public void setY (Float y) throws IncorrectValueException {
        if (y == null) {
            throw new IncorrectValueException("поле не может быть пустым");
        }
        this.y = y;
    }

    public Float getY () {
        return y;
    }


    public void setZ (Long z) throws IncorrectValueException {
        if (z == null) {
            throw new IncorrectValueException("поле не может быть пустым");
        }
        this.z = z;
    }

    public Long getZ () {
        return z;
    }

    public void setName (String name) throws IncorrectValueException {
        if (name == "") {
            throw new IncorrectValueException("поле не может быть пустым");
        }
        this.name = name;
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return "{\"x\" : " + Float.toString(x) + ", \"y\" : " + Float.toString(y) + ", \"z\" : " + Long.toString(z) + ", \"location name\" " + name + "}";
    }
}