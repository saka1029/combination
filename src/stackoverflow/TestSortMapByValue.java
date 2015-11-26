package stackoverflow;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class TestSortMapByValue {

    public static <K, V> LinkedHashMap<K, V> sort(Map<K, V> map, Comparator<Entry<K, V>> comparator) {
        return map.entrySet().stream()
            .sorted(comparator)
            .collect(() -> new LinkedHashMap<K, V>(),
                (m, e) -> m.put(e.getKey(), e.getValue()),
                (a, b) -> a.putAll(b));
    }

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 4);
        map.put("c", 6);
        map.put("b", 2);
//        System.out.println(sort(map, (e, f) -> f.getValue() - e.getValue()));
        System.out.println(sort(map, Entry.comparingByValue((a, b) -> b - a)));
    }

}
