package aoc;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/** Reads files from the git-ignored inputs/ folder. */
public final class Input {
    private static final Path DIR = Path.of("inputs");

    private Input() {}

    public static Path puzzle(int day) {
        return DIR.resolve(String.format("day%02d.txt", day));
    }

    public static Path example(int day) {
        return DIR.resolve(String.format("day%02d-example.txt", day));
    }

    public static List<String> lines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new UncheckedIOException("Could not read " + path.toAbsolutePath(), e);
        }
    }
}
