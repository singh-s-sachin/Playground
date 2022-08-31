package lld;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

//Requirements
/**
 * A Car Object
 * CarID
 * Make
 * Model
 * Color
 * Number
 * Location
 * Address
 * CarStatus (enum)
 * <p>
 * CarStatus
 * BOOKED, AVAILABLE, NOT_AVAILABLE
 * <p>
 * A Location Object
 * Latitute, Longitude
 * <p>
 * Parent - User (Customer/Vendor)
 * Name
 * UserID
 * Location
 * Ratings
 * <p>
 * Customers extend User
 * List<Booking>
 * Wallet
 * Address
 * getBookings();
 * getAvailableCars(SearchParams, Location);
 * makeBooking(carID, date);
 * cancelBooking(BookingID);
 * updateBookings(BookingID);
 * <p>
 * Vendors extend User
 * List<Cars>
 * Wallet
 * Address
 * changeCarStatus(carID, carStatus);
 * getAvailableCars();
 * getBooking(date);
 * addCar(Car)
 * <p>
 * Booking
 * BookingID
 * Car
 * Vendor
 * Date
 * BookingStatus (enum)
 * <p>
 * Status
 * BOOKED,PENDING,IN_PROGRESS,CANCELLED
 */

public class ZoomCar {
    public class Car {
        Long carID;
        int year;
        String brand;
        String model;
        String color;
        String number;
        Location location;
        Address address;
        CarStatus carStatus;
        CarDoc carDoc;
    }

    public class User {
        String userID;
        String name;
        Location location;
        Address address;
        int rating;
    }

    public class Customer extends User {
        List<Booking> bookings;
        Wallet wallet;
        Address address;

        public List<Booking> getBookings() {
            //Code goes here
            return null;
        }

        public PagedCarResponse getAvailableCars(SearchParams searchParams, Page page) {
            //Code goes here
            return null;
        }

        public Booking makeBooking(String carID, ZonedDateTime date) {
            //Code goes here
            return null;
        }

        public Booking cancelBooking(String bookingID) {
            //Code goes here
            return null;
        }

        public Booking updateBookings(Booking booking) {
            //Code goes here
            return null;
        }
    }

    public class Vendor extends User {
        List<Car> cars;
        Wallet wallet;
        Address address;
        String GSTN;

        public Car changeCarStatus(String carID, CarStatus carStatus) {
            //Code goes here
            return null;
        }

        public List<Car> getAvailableCars() {
            //Code goes here
            return null;
        }

        public List<Booking> getBooking(ZonedDateTime dateTime) {
            //Code goes here
            return null;
        }

        public List<Car> addCar(Car car) {
            //Code goes here
            return null;
        }
    }

    public class Wallet {
        String walletID;
        BigDecimal amount;
        ZonedDateTime lastTransactionDate;
        ZonedDateTime createdDateTime;
    }

    public class Booking {
        String bookingID;
        Car car;
        Vendor vendor;
        ZonedDateTime dateTime;
        BookingStatus bookingStatus;
    }

    public enum BookingStatus {
        BOOKED, PENDING, IN_PROGRESS, CANCELLED
    }


    public class Location {
        float latitude;
        float longitude;
    }

    public class Address {
        String addressLine1;
        String addressLine2;
        String addressLine3;
        String city;
        String state;
        String country;
        String zip;
    }

    public enum CarStatus {
        BOOKED, AVAILABLE, NOT_AVAILABLE
    }

    public class CarDoc {
        String pucRef;
        ZonedDateTime pucEndDate;
        String rcRef;
        ZonedDateTime carExpiry;
    }

    public class SearchParams {
        int year;
        String brand;
        String model;
        String color;
        Location location; //Mandatory
        CarStatus carStatus;
    }

    public class PagedCarResponse {
        List<Car> car;
        Page page;
    }

    public class Page {
        int pageNo;
        int limit;
    }
}
