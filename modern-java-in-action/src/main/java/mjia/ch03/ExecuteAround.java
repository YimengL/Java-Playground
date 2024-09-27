package mjia.ch03;

import java.io.BufferedReader;

public class ExecuteAround {

    public static void main(String[] args) {

    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws Exception;
    }
}
