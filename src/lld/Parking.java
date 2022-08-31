package lld;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class Parking {
    /**
     * class ParkingLot
     * ParkingLotID
     * List<Cars>
     * List<Booking>
     * List<Staff>
     * Address
     * Location
     * ThresholdMap<String, int>
     * ParkingLotStatus
     * public void park(Car car);
     * public boolean hasAvailableLot(CarType carType);
     * public void addStaff(Staff staff)
     * parkingReceipt makeBooking(carID, ZonedDateTime datetime, int hours);
     * <p>
     * <p>
     * class Car
     * CarType
     * CarNumber
     * EntryTime
     * ExitTime
     * public BigDecimal getCharges()
     * <p>
     * class User
     * name
     * userid
     * Role
     * boolean isStaff();
     * boolean isAdmin();
     * boolean isCustomer();
     * Role getRole();
     * <p>
     * class Staff extends User
     * ParkingLotID
     * boolean isActive
     * Address
     * public boolean isActiveNow();
     * public Car makeEntry(carID)
     * public ParkingReceipt makeExit(carID)
     * public boolean changeStatus(boolean isActive);
     * <p>
     * class Admin extends User
     * List<ParkingLot>
     * getHouseFulParkingLots()
     * getParkingLots()
     * changeStatus(ParkingLotID, ParkingLotStatus)
     * public void addStaff(ParkingLotID, Staff staff)
     * public boolean markStaffAttendance(String userID, boolean isActive);
     * <p>
     * class Customer extends User
     * List<Car> cars
     * Map<Car, BigDecimal> getCharges()
     * addCar()
     * List<ParkingLots> getParkingsNearMe()
     * ParkingReceipt makeBooking(Booking)
     * <p>
     * <p>
     * ParkingReceipt
     * ParkingLocationID
     * From
     * To
     * Charges
     * ReceiptStatus
     */


    class ParkingLot {
        String parkingLotID;
        List<Car> cars;
        List<Booking> bookings;
        List<Staff> staffs;
        Address address;
        Location location;
        Map<CarType, Integer> thresholdMap;
        ParkingLotStatus parkingLotStatus;

        public void park(Car car) {
            //code goes here
        }

        public boolean hasAvailableLot(CarType carType) {
            //code goes here
            return false;
        }

        public Booking makeBooking(String carID, ZonedDateTime datetime, int hours) {
            //code goes here
            return null;
        }
    }

    class Car {
        CarType carType;
        String carNumber;
    }

    abstract class User {
        String name;
        String userId;

        public abstract Role getRole();
    }

    class Staff extends User {

        boolean isActive;
        Address address;

        public boolean isActiveNow() {
            return false;
        }

        public Car makeEntry(String carID) {
            //code goes here
            return null;
        }

        public Booking makeExit(String carID) {
            //code goes here
            return null;
        }


        @Override
        public Role getRole() {
            return Role.STAFF;
        }
    }

    class Admin extends User {
        List<ParkingLot> parkingLots;

        public List<ParkingLot> getHouseFulParkingLots() {
            //code goes here
            return null;
        }

        public List<ParkingLot> getParkingLots() {
            //code goes here
            return null;
        }

        public ParkingLot changeStatus(String ParkingLotID, ParkingLotStatus parkingLotStatus) {
            //code goes here
            return null;
        }

        public void addStaff(Staff staff) {
            //code goes here
        }

        public boolean markStaffAttendance(String userID, boolean isActive) {
            //code goes here
            return false;
        }

        @Override
        public Role getRole() {
            return Role.ADMIN;
        }
    }

    class Customer extends User {

        List<Car> cars;

        List<Booking> bookings;

        public Map<Car, BigDecimal> getCharges() {
            //code goes here
            return null;
        }

        public void addCar(Car car) {
            //code goes here
        }

        public List<ParkingLot> getParkingsNearMe() {
            //code goes here
            return null;
        }

        @Override
        public Role getRole() {
            return null;
        }
    }

    class Booking
    {
        Car car;
        ParkingLot parkingLot;
        ZonedDateTime from;
        ZonedDateTime to;
        BookingStatus bookingStatus;

        public BigDecimal getCharges() {
            //code goes here
            return null;
        }
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

    enum Role {
        ADMIN, STAFF, CUSTOMER
    }

    enum CarType {
        LMV, HMV, MV
    }

    enum ParkingLotStatus {
        OPEN, CLOSED, HOUSE_FULL
    }

    enum BookingStatus{
        RESERVED, PAYMENT_PENDING
    }
}
