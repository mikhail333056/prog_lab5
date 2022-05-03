package data;

import exceptions.IncorrectValueException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

/**
 * An element of the collection that stores data about a person
 */
public class Person implements Comparable <Person> {
    /**
     * The person's ID. The key for the collection is unique for each item in the collection
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * The person's name cannot be empty
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * Human coordinates. The field cannot be null
     */
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    /**
     * Date of creation of the person in the collection
     */
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * Human height. The field value must be greater than 0
     */
    private Integer height; //Значение поля не может быть null. Значение поля должно быть больше 0

    /**
     * Human weight. The field can be null, the field value must be greater than 0
     */
    private Color eyeColor; //Поле может быть null

    /**
     * Human HairColor. The field can be null
     */
    private Color hairColor; //Поле может быть null

    /**
     * Human nationality. The field can be null
     */
    private Country nationality; //Поле может быть null

    /**
     * Human location. The field cannot be null
     */
    private Location location = new Location(); //Поле не может быть null

    /**
     * Empty constructor for class initialization
     */
    public Person () {

    }

    /**
     * Basic constructor of the Person class
     * @param person the basic element of the collection
     */
    public Person (final Person person) {
        id = person.id;
        name = person.name;
        coordinates = new Coordinates(person.coordinates);
        creationDate = person.creationDate;
        height = person.height;
        eyeColor = person.eyeColor;
        hairColor = person.hairColor;
        nationality = person.nationality;
        location = new Location(person.location);
    }

    /**
     * Compares two elements of the collection by the id parameter
     * @param person the basic element of the collection
     * @return values of 1, 0 or -1 when comparing two elements of the collection by their id
     */
    public int compareTo (final Person person) {
        return (id-person.getId()>0)?1:((id-person.getId()==0)?0:-1);
    }

    /**
     * Generates a unique id for the collection
     * @param treeMap that collection where we'll check id for unique
     * @return long unique id for this treeMap
     */
    public static int generateUniqueId (final TreeMap<Integer, Person> treeMap) {
        int id;
        if (!treeMap.isEmpty())
            id = treeMap.lastKey()+1;
        else
            id = 1;
        while (!checkUniqueId(treeMap, id))
            id+=1;
        return id;
    }

    /**
     * Checks the id value for uniqueness in a given collection
     * @param treeMap that collection where we'll check id for unique
     * @param id The id value being checked
     * @return true if the id value is unique for this collection. Otherwise false
     */
    public static boolean checkUniqueId (final TreeMap<Integer, Person> treeMap, final int id) {
        return !treeMap.containsKey(id);
    }

    // подаётся УНИКАЛЬНОЕ значение

    /**
     * Set id to this person
     * @param id value that set to this person
     * @throws IncorrectValueException if id lower than 0
     */
    public void setId (final int id) throws IncorrectValueException {
        if (id <= 0)
            throw new IncorrectValueException("id должно быть больше 0");
        this.id = id;
    }

    /**
     * Returns the id of the Person element
     * @return the id value of this Person
     */
    public int getId () {
        return id;
    }

    /**
     * Set name to this person
     * @param name value that set to this person
     * @throws IncorrectValueException if name contains null or is an empty string
     */
    public void setName (final String name) throws IncorrectValueException {
        if (name == null || name.equals(""))
            throw new IncorrectValueException("имя не может быть пустым");
        this.name = name;
    }

    /**
     * Returns the name of the Person element
     * @return the name value of this Person
     */
    public String getName () {
        return name;
    }

    /**
     * Set name to this person
     * @param coordinates value that set to this person
     * @throws IncorrectValueException if coordinates contains null
     */
    public void setCoordinates (final Coordinates coordinates) throws IncorrectValueException {
        if (coordinates == null)
            throw new IncorrectValueException("значения координат не могут быть пустыми");
        this.coordinates = coordinates;
    }

    /**
     * Returns the coordinates of the Person element
     * @return the coordinates of this Person
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Set creation date to this person
     * @param creationDate value that set to this person
     * @throws IncorrectValueException if creationDate contains null
     */
    public void setCreationDate (final java.util.Date creationDate) throws IncorrectValueException {
        if (creationDate == null)
            throw new IncorrectValueException("дата создания не может быть пустой");
        this.creationDate = creationDate;
    }

    /**
     * Returns the creation date of the Person element
     * @return the creation date of this Person
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * Set height to this person
     * @param height value that set to this person
     * @throws IncorrectValueException if contains a value less than or equal to 0
     */
    public void setHeight (final Integer height) throws IncorrectValueException {
        if (height <= 0)
            throw new IncorrectValueException("рост должен быть положительным");
        this.height = height;
    }

    /**
     * Returns the height of the Person element
     * @return the height of this Person
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set eye color to this person
     * @param eyeColor A field of the Color class to be set for this person
     */
    public void setEyeColor (final Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Set eye color to this person
     * @param eyeColor A string field that is set to this person, if such a value is registered in the Color class
     */
    public void setEyeColor (final String eyeColor) {
        for (Color i: Color.values()) {
            if (i.toString().equals(eyeColor.toUpperCase())) {
                this.eyeColor = i;
                return;
            }
        }
        this.eyeColor = null;
    }
    /**
     * Returns the eye color of the Person element
     * @return the eye color of this Person
     */
    public Color getEyeColor () {
        return eyeColor;
    }
    /**
     * Set hair color to this person
     * @param hairColor A field of the Color class to be set for this person
     */
    public void setHairColor (final Color hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Set hair color to this person
     * @param hairColor A string field that is set to this person, if such a value is registered in the Color class
     */
    public void setHairColor (final String hairColor) {
        for (Color i: Color.values()) {
            if (i.toString().equals(hairColor.toUpperCase())) {
                this.hairColor = i;
                return;
            }
        }
        this.hairColor = null;
    }

    /**
     * Returns the hair color of the Person element
     * @return the hair color of this Person
     */
    public Color getHairColor () {
        return hairColor;
    }

    /**
     * Set location to this person
     * @param location value that set to this person
     * @throws IncorrectValueException if location contains null
     */
    public void setLocation (final Location location) throws IncorrectValueException {
        if (location == null)
            throw new IncorrectValueException("местоположение не может быть пустым");
        this.location = location;
    }

    /**
     * Returns the location of the Person element
     * @return the location of this Person
     */
    public Location getLocation () {
        return location;
    }

    /**
     * Set nationality to this person
     * @param nationality a field of the Country class to be set for this person
     */
    public void setNationality (final Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Set nationality to this person
     * @param nationality A string field that is set to this person, if such a value is registered in the Country class
     */
    public void setNationality (final String nationality) {
        for (Country i: Country.values()) {
            if (i.toString().equals(nationality.toUpperCase())) {
                this.nationality = i;
                return;
            }
        }
        this.nationality = null;
    }

    /**
     * Returns the nationality of the Person element
     * @return the nationality of this Person
     */
    public Country getNationality () {
        return nationality;
    }

    /**
     * Returns a string with the values of all fields of the Person element
     * @return a string with the fields of the collection element
     */
    @Override
    public String toString () {
        return "\n{" +
                "\nid: "+id+
                "\nname: "+name+
                "\ncoordinates: "+coordinates.toString()+
                "\ncreationDate: "+creationDate+
                "\nheight: "+height+
                "\nweight: "+(eyeColor==null?"-":eyeColor)+
                "\nhairColor: "+(hairColor==null?"-":hairColor)+
                "\nnationality: "+(nationality==null?"-":nationality)+
                "\nlocation: "+location.toString()+
                "\n}\n";
    }

    /**
     * Implements the conversion of the date format to the required form
     * @param date An element of the ZonedDateTime class that is brought to the required output format
     * @return a string with the creation date of the collection element in the specified format
     */
    private static String dateFormat(ZonedDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS O VV");
        return formatter.format(date);
        //return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear()+" "+date.getHour()+":"+date.getMinute()+":"
        //        +date.getSecond()+":"+date.getNano()+" Zone: "+date.getOffset()+" "+date.getZone();
    }
}