package in.tp.jsedemo.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeApiDemoApp {

	public static void main(String[] args) {
		
		LocalDateTime startTime = LocalDateTime.now();
		System.out.println(startTime);
				
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate indianIndependence = LocalDate.of(1947, Month.AUGUST,15);
		System.out.println(indianIndependence);
		
		ZonedDateTime currentInNewYork = ZonedDateTime.now(ZoneId.of("GMT-4"));		
		System.out.println(currentInNewYork);
		
		Period p = Period.between(indianIndependence, today);
		System.out.println(p);
		
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(endTime);
		
		Duration d = Duration.between(startTime, endTime);
		System.out.println(d);
		
		System.out.println(today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		System.out.println(today.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
		System.out.println(today.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
		
	}

}
