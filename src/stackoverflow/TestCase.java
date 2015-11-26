package stackoverflow;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class TestCase {

    @Test
    public void testInfiniteStream() {
        // create a stream from 0 (inclusive) to 100 (exclusive)
        IntStream.range(0, 100)

        // convert to Integer objects
        .boxed()

        // group by tens
        /* ugly: */.collect(Collectors.groupingBy(i -> i / 10)).entrySet().stream()
        /* not working: */ //.makeSequentialGroups(i -> i / 10)

        // print to console
        .forEach(System.out::println);
    }
    
    @Test
    public void shouldBeAbleToReturnTheKeyOfTheFirstMatchingValue() throws Exception {
        Map<String, String> names = new LinkedHashMap<>();
        names.put("John", "Doe");
        names.put("Fred", "Flintstone");
        names.put("Jane", "Doe");
        String keyOfTheFirst = names.entrySet().stream().filter(e -> e.getValue().equals("Doe")).findFirst().get().getKey();
        assertEquals("John", keyOfTheFirst);

        try {
            names.entrySet().stream().filter(e -> e.getValue().equals("Donkey")).findFirst().get();
        } catch (NoSuchElementException e){
            // Expected
        }

        Optional<Map.Entry<String, String>> optionalEntry = names.entrySet().stream().filter(e -> e.getValue().equals("Donkey")).findFirst();
        keyOfTheFirst = optionalEntry.isPresent() ? optionalEntry.get().getKey() : null;

        assertNull(keyOfTheFirst);
        
    }
    
    String findBySurname(Map<String, String> names, String surname) {
        for (Entry<String, String> e : names.entrySet())
            if (e.getValue().equals(surname))
                return e.getKey();
        return null;
    }

    static <K, V> K findFirstKeyByValue(Map<K, V> map, String value) {
        for (Entry<K, V> e : map.entrySet())
            if (e.getValue().equals(value))
                return e.getKey();
        return null;
    }

    @Test
    public void testConsole() {
        System.out.println(System.console().readLine());
    }
    
    enum State {
        enable,disable,deleted;
    }

    @Test
    public void TestEnumState() {
        for ( State s : State.enable.disable.values() )
            System.out.println(s);
    }
}
