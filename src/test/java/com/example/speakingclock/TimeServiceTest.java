
package com.example.speakingclock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.speakingclock.exception.InvalidTimeFormatException;
import com.example.speakingclock.service.TimeService;

@SpringBootTest
public class TimeServiceTest {

	private final TimeService timeService = new TimeService();

	@Test
	public void testMidnight() {
		assertEquals("It's Midnight", timeService.convertTimeToWords("00:00"));
	}

	@Test
	public void testMidday() {
		assertEquals("It's Midday", timeService.convertTimeToWords("12:00"));
	}

	@Test
	public void testValidTime() {
		assertEquals("It's eight thirty four", timeService.convertTimeToWords("08:34"));
	}

	@Test(expected = InvalidTimeFormatException.class)
	public void testInvalidFormat() {
		timeService.convertTimeToWords("8:34");
	}

	@Test(expected = InvalidTimeFormatException.class)
	public void testInvalidTimeRange() {
		timeService.convertTimeToWords("25:00");
	}
}
