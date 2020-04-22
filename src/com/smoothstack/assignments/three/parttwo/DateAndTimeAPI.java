package com.smoothstack.assignments.three.parttwo;

import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeAPI {

    public static void main(String[] args) {
        DateAndTimeAPI q2 = new DateAndTimeAPI();

        // Question 1
        q2.birthday();

        // Question 2
        LocalDateTime lastThursday = q2.findPreviousThursday(LocalDateTime.now());
        System.out.println(lastThursday);

        // Question 3
        q2.zoneIDorZoneOffset();

        // Question 4
        q2.instantAndZonedDateTime();

        // Question 5
        q2.lengthOfMonthsInAYear(2020);

        // Question 6
        q2.listMondays(3);

    }

    // Question 1
    public void birthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss,nnnnnnnnnZ");
        ZoneOffset timeDifference = ZoneOffset.of("-05:00");
        OffsetDateTime birthday = OffsetDateTime.of(1998, 2, 4, 8, 0, 0, 123456789, timeDifference);
        System.out.println(birthday.format(formatter));
    }

    // Questoin 2
    public LocalDateTime findPreviousThursday(LocalDateTime dateTime) {
        int weekDay = dateTime.getDayOfWeek().getValue();
        LocalDateTime lastThursday;

        switch (weekDay) {
            case 1:
                lastThursday = dateTime.minusDays(4);
                break;
            case 2:
                lastThursday = dateTime.minusDays(5);
                break;
            case 3:
                lastThursday = dateTime.minusDays(6);
                break;
            case 4:
                lastThursday = dateTime.minusDays(7);
                break;
            case 5:
                lastThursday = dateTime.minusDays(1);
                break;
            case 6:
                lastThursday = dateTime.minusDays(2);
                break;
            case 7:
                lastThursday = dateTime.minusDays(3);
                break;
            default:
                lastThursday = dateTime;
        }
        return lastThursday;
    }

    // Question 3
    public void zoneIDorZoneOffset() {
        // Zone ID is created using a string of the zone's locations
        System.out.println("\nCurrent time of Paris:");
        ZoneId zoneWithString = ZoneId.of("Europe/Paris");
        System.out.println(LocalDateTime.now(zoneWithString));
        // Zone Offset is a subclass of ZoneID and uses the time-zone offsed 
        System.out.println("Current Eastern Time in US:");
        ZoneOffset zoneWithUTC = ZoneOffset.of("-05:00");
        System.out.println(LocalDateTime.now(zoneWithUTC));
    }

    // Question 4
    public void instantAndZonedDateTime() {
        // Create a ZonedDateTime from an instant
        Instant instant = Instant.now();
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedInstant = instant.atZone(zone);
        System.out.println(zonedInstant);

        //Create an instant from a ZonedDateTime
        ZonedDateTime zoneDateTime = ZonedDateTime.now(zone);
        instant = zoneDateTime.toInstant();
        System.out.println(instant); 
    }

    // Qeustion 5
    public void lengthOfMonthsInAYear(int year) {
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();

        // Print the length of each month
        for(int i=1;i<13;i++) {
            System.out.println("Length of " + months[i - 1] + " = " + LocalDate.of(year, i,1).lengthOfMonth() + " days.");
        }
    }

    // Question 6
    public void listMondays(int month) {
        LocalDate currentMonth = LocalDate.of(2020, month, 01);
        int lengthOfMonth = currentMonth.lengthOfMonth();
        LocalDate currentDay;
        int dayOfWeek;
        String curMonthStr = currentMonth.getMonth().toString();
        
        System.out.println("All mondays in " + curMonthStr + " 2020.");
        
        for(int i=1; i <= lengthOfMonth; i++) {
            currentDay = LocalDate.of(2020, month, i);
            dayOfWeek = currentDay.getDayOfWeek().getValue();

            if (dayOfWeek == 1) {
                System.out.println("Monday the " + i + " of " + curMonthStr + " 2020.");
            }
        }
    }

    // Question 7
    public boolean isLocalDateFriday13th(LocalDate date) {
        if(date.getDayOfMonth() == 13 && date.getDayOfWeek().getValue() == 5) {
            return true;
        } else {
            return false;
        }
    }
}