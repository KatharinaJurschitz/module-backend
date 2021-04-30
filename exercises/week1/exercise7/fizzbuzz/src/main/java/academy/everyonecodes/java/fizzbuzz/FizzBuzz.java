package academy.everyonecodes.java.fizzbuzz;

public class FizzBuzz {
    private final MultipleFinder multipleOfThree;
    private final MultipleFinder multipleOfFive;

    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply(int input) {
        if (multipleOfFive.isMultiple(input) && multipleOfThree.isMultiple(input)) {
            return "FizzBuzz";
        } else if (multipleOfThree.isMultiple(input)) {
            return "Fizz";
        } else if (multipleOfFive.isMultiple(input)) {
            return "Buzz";
        } else {
            return String.valueOf(input);
        }
    }
}
