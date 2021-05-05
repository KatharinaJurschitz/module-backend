package academy.everyonecodes.java.creditcards;

import org.springframework.stereotype.Service;

@Service
public class Luhn {
    public boolean isValid(String input) {
        int nDigits = input.length();

        int nSum = 0;
        boolean isSecond = false;

        for (int i = nDigits - 1; i >= 0; i--) {

            int d = input.charAt(i) - '0';

            if (isSecond) {
                d = d * 2;
            }

            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }

        return (nSum % 10 == 0);

//        long num = Long.parseLong(input);
//        int sum = 0;
//
//        int sumTimesTwo = 0;
//        int pos1 = input.length() - 2;
//        while (num > 0) {
//            int digit = (int) (num % 10);
//            if (pos1 % 2 == 0) {
//                sumTimesTwo += digit;
//            }
//            num /= 10;
//            pos1 -= 2;
//        }
//
//        int sumTimesOne = 0;
//        int pos2 = input.length() - 1;
//        while (num > 0) {
//            int digit = (int) (num % 10);
//            if (pos1 % 2 == 0) {
//                sumTimesOne += digit;
//            }
//            num /= 10;
//            pos2 -= 2;
//        }
//
//        if (input.length() % 2 == 0) {
//            sum = sumTimesOne + (sumTimesTwo * 2);
//        } else {
//            sum = sumTimesTwo + (sumTimesOne * 2);
//        }
//
//        return sum % 10 == 0;
    }
}
