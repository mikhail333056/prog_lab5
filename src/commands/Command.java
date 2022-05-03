package commands;

/**
 * A abstract class that defines the basic construction of implemented commands
 */
public abstract class Command implements Executable {

    private final String name;
    private final String signature;
    private final String description;

    Command (final String name, final String signature, final String description) {
        this.name = name;
        this.signature = signature;
        this.description = description;
    }

    public String getName () {
        return name;
    }
    public String getSignature () {
        return signature;
    }
    public String getDescription () {
        return description;
    }

}