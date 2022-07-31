package week8;

// You are provided with a m x n grid representing rooms in the house with the following
// information:
// '*' represents an empty cell.
// '#' is a wall.
// The starting point is '@'.
// Keys are represented lower case letters.
// Locks are represented by capital letters.
// You begin at the beginning and make one move by walking one space in one of the four
// cardinal directions. You cannot wander off the beaten path or into a wall. You can pick
// up a key if you walk over it, but you cannot walk over a lock unless you have the
// associated key.
// There is exactly one lowercase and one capital letter from the first k letters of the English
// alphabet in the grid for some 1= k = 6.

public class PathInRoom {
    int rows;
    int columns;
    String input[];

    PathInRoom(String input[]) {
        this.input = input;
        this.rows = input.length;
        this.columns = input[0].length();

    }

    public int FindNumberOfKeys() {

        int GivenAlphabets = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#'
                        || input[i].charAt(j) == '*') {
                    continue;
                } else {
                    GivenAlphabets++;
                }
            }
        }
        int keys = GivenAlphabets / 2;
        return keys;

    }

    int Travel() {
        int keys = FindNumberOfKeys();
        int TotalTravels = 0;
        int FoundKeys = 0;
        boolean run = true;
        int x = 0;
        int RowTravelled = 0;
        int addition = 1;
        char kFound[] = new char[2];
        while (run) {
            if (input[RowTravelled].charAt(x + addition) != '#') {
                if (input[RowTravelled].charAt(x + addition) == '*') {
                    TotalTravels++;
                    x = x + addition;
                    continue;
                } else {
                    if (input[RowTravelled].charAt(x + addition) != input[RowTravelled].toUpperCase()
                            .charAt(x + addition)) {
                        kFound[FoundKeys] = input[RowTravelled].charAt(x + addition);
                        TotalTravels++;
                        x = x + addition;
                        FoundKeys++;

                        if (FoundKeys == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        boolean found = false;

                        for (int i = 0; i < kFound.length; i++) {
                            if (kFound[i] == input[RowTravelled].toLowerCase().charAt(x + addition)) {
                                found = true;

                            }
                        }
                        if (found) {
                            TotalTravels++;
                            x = x + addition;
                            continue;
                        } else {
                            addition = addition * -1;
                            continue;
                        }
                    }
                }

            }
            if (input[RowTravelled + 1].charAt(x) != '#') {
                if (input[RowTravelled + 1].charAt(x) == '*') {
                    TotalTravels++;
                    RowTravelled += 1;
                    continue;
                } else {
                    if (input[RowTravelled + 1].charAt(x) != input[RowTravelled + 1].toUpperCase().charAt(x)) {
                        kFound[FoundKeys] = input[RowTravelled + 1].charAt(x);
                        TotalTravels++;
                        RowTravelled += 1;
                        FoundKeys++;
                        if (FoundKeys == keys) {
                            run = false;
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        boolean found = false;
                        for (int i = 0; i < kFound.length; i++) {
                            if (kFound[i] == input[RowTravelled + 1].toLowerCase().charAt(x)) {
                                found = true;

                            }
                        }
                        if (found) {
                            TotalTravels++;
                            RowTravelled++;
                            continue;
                        }

                    }
                }
            }
        }
        return TotalTravels;
    }

    public static void main(String[] args) {
        String value[] = { "@*a*#", "###*#", "b*A*B" };
        PathInRoom p = new PathInRoom(value);
        System.out.println(p.Travel());
    }

}
