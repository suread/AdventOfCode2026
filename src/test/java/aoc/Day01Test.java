package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.Test;

class Day01Test {
    private final Day day = new Day01();

    private List<String> example() {
        assumeTrue(Files.exists(Input.example(1)), "inputs/day01-example.txt not found - skipping");
        return Input.lines(Input.example(1));
    }

    @Test
    void part1Example() {
        assertEquals("TODO", day.part1(example())); // replace with the example answer
    }

    @Test
    void part2Example() {
        assertEquals("TODO", day.part2(example())); // replace with the example answer
    }
}
