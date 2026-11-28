package aoc;

import java.util.List;

public class Day01 implements Day {

    private static final int DIAL_SIZE = 100;

    @Override
    public String part1(List<String> lines) {
        int zeroCount = 0;
        int currPos = 50;

        for (String rotationString : lines) {
            char direction = rotationString.charAt(0);
            int distance = Integer.parseInt(rotationString.substring(1));

            if (direction == 'L') {
                currPos -= distance;
            } else {
                currPos += distance;
            }
            currPos = Math.floorMod(currPos, DIAL_SIZE);

            if (currPos == 0) zeroCount++;
        }

        return Integer.toString(zeroCount);
    }

    @Override
    public String part2(List<String> lines) {
        int zeroCount = 0;
        int currPos = 50;

        for (String rotationString : lines) {
            char direction = rotationString.charAt(0);
            int distance = Integer.parseInt(rotationString.substring(1));

            // count and remove full rotations - each will inevitably go through 0
            zeroCount += distance / DIAL_SIZE;
            distance = distance % DIAL_SIZE;

            if (direction == 'L') {
                if (currPos == 0) currPos = DIAL_SIZE;
                currPos -= distance;
                if (currPos == 0) zeroCount ++;
                if (currPos < 0) {
                    currPos += DIAL_SIZE;
                    zeroCount ++;
                }
            } else {
                currPos += distance;
                if (currPos > DIAL_SIZE - 1) {
                    currPos -= DIAL_SIZE;
                    zeroCount ++;
                }
            }
        }

        return Integer.toString(zeroCount);
    }


}
