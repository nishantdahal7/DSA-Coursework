package week5;

// you are provided with an array A [] containing set of different words in the form of string
// and you are provided with targeted word,
// return length of subset s from set A required to from targeted word by using
// combination of different letters of subset s.
// input: A [] = {"Programming","for","developers"} target="frog"
// Output: 2
// Explanation: subset ["Programming”, “for"] of length can be used to form word frog.

public class FormTargetedWord {

    static void Subset(String target, String set[]) {
        String match = ""; // stores the set visited.
        int answer = 0; // stores the words required to form the target.

        for (int i = 0; i < target.length(); i++) { // loops through the target array string.
            for (int j = 0; j < set.length; j++) { // loops through the set array .
                for (int k = 0; k < set[j].length(); k++) { // loops through every Srring in the set array.
                    if (target.charAt(i) == set[j].charAt(k) && !match.contains(target.charAt(i) + "")) { // if target
                                                                                                          // char
                                                                                                          // matches to
                                                                                                          // char at
                                                                                                          // given
                                                                                                          // string, and
                                                                                                          // its not
                                                                                                          // placed in
                                                                                                          // the match,
                                                                                                          // we add it
                                                                                                          // to match.
                        match += target.charAt(i);

                        if (answer <= j + 1) { // if answer is less than or equal to the index of the set array + 1.
                            answer++; // we increment the answer.
                        }

                    }

                }
            }
        }
        System.out.println(answer); // prints the final added answer.
    }

    public static void main(String[] args) {
        String set[] = { "Programming", "for", "developers" };
        String target = "frog";
        Subset(target, set);
    }

}
