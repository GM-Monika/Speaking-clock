
package com.example.speakingclock.controller;

import com.example.speakingclock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

	@Autowired
	private TimeService timeService;

	@GetMapping("/convert")
	public ResponseEntity<String> convertTime(@RequestParam String inputTime) {
		String result = timeService.convertTimeToWords(inputTime);
		return ResponseEntity.ok(result);
	}
}
