package chainresponsibility;

import org.apache.log4j.Logger;
import java.util.function.Predicate;

public class ChainResponsibility<T> {

    private static final Logger LOGGER =  Logger.getLogger(Main.class);
    private String name;
    private Predicate<T> predicate;
    private ChainResponsibility next;


    public ChainResponsibility(String name, Predicate<T> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public void setNext(ChainResponsibility next) {
        this.next = next;
    }


    public void process(T message) {
        LOGGER.info("Signal " + name + " value: " + message);
        if(predicate.test(message)) {
            if (next != null) {
                next.process(message);
            }
        }
    }
}
