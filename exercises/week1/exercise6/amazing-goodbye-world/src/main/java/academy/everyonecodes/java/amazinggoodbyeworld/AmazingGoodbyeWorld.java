package academy.everyonecodes.java.amazinggoodbyeworld;

public class AmazingGoodbyeWorld {
    Goodbye goodbye;
    World world;

    public AmazingGoodbyeWorld(Goodbye goodbye, World world) {
        this.goodbye = goodbye;
        this.world = world;
    }

    public String get() {
        return goodbye.get() + " " + world.get();
    }
}
