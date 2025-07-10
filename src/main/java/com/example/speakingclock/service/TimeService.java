
package com.example.speakingclock.service;

import com.example.speakingclock.exception.InvalidTimeFormatException;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

	private static final String[] HOURS = { "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve" };
	private static final String[] MINUTES = { "oh", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	private static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty" };

	public String convertTimeToWords(String inputTime) {
		if (!inputTime.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
			throw new InvalidTimeFormatException("Invalid time format: " + inputTime);
		}

		String[] parts = inputTime.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		if (hour == 0 && minute == 0)
			return "It's Midnight";
		if (hour == 12 && minute == 0)
			return "It's Midday";

		StringBuilder timeInWords = new StringBuilder("It's ");
		timeInWords.append(HOURS[hour % 12 == 0 ? 12 : hour % 12]).append(" ");

		if (minute == 0) {
			timeInWords.append("o'clock");
		} else if (minute < 20) {
			timeInWords.append(MINUTES[minute]);
		} else {
			timeInWords.append(TENS[minute / 10]);
			if (minute % 10 != 0) {
				timeInWords.append(" ").append(MINUTES[minute % 10]);
			}
		}

		return timeInWords.toString().trim();
	}
}
