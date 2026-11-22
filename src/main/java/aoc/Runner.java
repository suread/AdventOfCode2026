package aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Runs a day against your personal input.
 * Usage: ./gradlew run --args="1"        (or run Runner from the IDE with program argument 1)
 */
public final class Runner {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: Runner <day number>");
            System.exit(1);
        }
        int day = Integer.parseInt(args[0]);
        Path file = Input.puzzle(day);
        if (!Files.exists(file)) {
            System.err.println("Missing input file: " + file.toAbsolutePath());
            System.exit(1);
        }

        Day solver = (Day) Class.forName(String.format("aoc.Day%02d", day))
                .getDeclaredConstructor().newInstance();
        List<String> lines = Input.lines(file);

        time("Part 1", () -> solver.part1(lines));
        time("Part 2", () -> solver.part2(lines));
    }

    private static void time(String label, java.util.function.Supplier<String> part) {
        long start = System.nanoTime();
        String answer = part.get();
        long ms = (System.nanoTime() - start) / 1_000_000;
        System.out.printf("%s: %s  (%d ms)%n", label, answer, ms);
    }
}
