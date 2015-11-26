package stackoverflow;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.spi.CharsetProvider;
import java.nio.file.Files;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSortFiles {

    interface ThrowableFunction<A, T> {
        T apply(A arg) throws Throwable;
    }

    static <A, T> Function<A, T> throwableFunction(ThrowableFunction<A, T> f) {
        return x -> {
            try {
                return f.apply(x);
            } catch (Throwable t) {
                t.printStackTrace();
                return null;
            }
        };
    }

    static String[] sort(File[] files, boolean parallel) {
        return (parallel ? Stream.of(files).parallel() : Stream.of(files))
            .flatMap(f -> {
                try {
                    return Files.lines(f.toPath());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            })
            .sorted()
            .toArray(String[]::new);
    }

    static String[] sort2(File[] files, boolean parallel) {
        Stream<String> stream = Stream.of(files)
            .flatMap(f -> {
                try {
                    return Files.lines(f.toPath());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            });
        return (parallel ? stream.parallel() : stream)
            .sorted()
            .toArray(String[]::new);
    }

    static String[] sort3(File[] files, boolean parallel) {
        return (parallel ? Stream.of(files).parallel() : Stream.of(files))
            .flatMap(f -> {
                try {
                    return Files.lines(f.toPath()).sorted();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            })
            .sorted()
            .toArray(String[]::new);
    }

    static String[] sort(File[] files) {
        return sort2(files, false);
    }

    static String[] threadSort(File[] files) {
        return sort2(files, true);
    }

    @Test
    public void testSortFiles() throws IOException {
        long start = System.currentTimeMillis();
        File root = new File("C:/git/saka1029/java/saka1029.aggregation/src/saka1029/aggregation/tenken/xds");
        File[] files = root.listFiles();
        String[] sorted = sort(files);
        System.out.println("sort:");
        System.out.println("files=" + files.length +" sorted lines=" + sorted.length + " elapse=" + (System.currentTimeMillis() - start) + "ms");
    }
    @Test
    public void testThreadSortFiles() throws IOException {
        long start = System.currentTimeMillis();
        File root = new File("C:/git/saka1029/java/saka1029.aggregation/src/saka1029/aggregation/tenken/xds");
        File[] files = root.listFiles();
        String[] sorted = threadSort(files);
        System.out.println("threadSort:");
        System.out.println("files=" + files.length +" sorted lines=" + sorted.length + " elapse=" + (System.currentTimeMillis() - start) + "ms");
    }

}
