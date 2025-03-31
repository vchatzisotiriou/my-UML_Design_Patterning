package util;

import java.time.LocalDateTime;
import java.util.Random;

public class Helper {
	
	static int assingPriority() {
		// Create an instance of the Random class
        Random random = new Random();
        
        // Generate a random integer between 1 and 10 (inclusive)
        int randomNumber = random.nextInt(10) + 1;
        
        return randomNumber;
	}
	
	static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}

}
