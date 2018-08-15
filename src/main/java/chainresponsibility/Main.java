package chainresponsibility;

import org.apache.log4j.MDC;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

    public static void main(String... args) {
        MDC.put("key", "MDC test");
        ArrayList<ChainResponsibility<Integer>> chainList = new ArrayList<>();
        ChainResponsibility<Integer> prevChain = null;
        Predicate<Integer> predicate = (x)-> x > 5;
        for (int i=0; i<10; i++) {
            ChainResponsibility<Integer> chain = new ChainResponsibility<Integer>("chain " + i, predicate);
            if (prevChain != null) {
                chain.setNext(prevChain);
            }
            prevChain = chain;
            chainList.add(chain);
        }

        for (int i=0; i<chainList.size(); i++) {
            chainList.get(i).process(i);
        }
    }
}
