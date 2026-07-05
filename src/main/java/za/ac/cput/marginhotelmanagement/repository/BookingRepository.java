package za.ac.cput.marginhotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.marginhotelmanagement.domain.Booking;
import za.ac.cput.marginhotelmanagement.enums.BookingChannel;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //Find booking by guest ID
    List<Booking> findByGuest_GuestId(Long guestId);

    //Find booking for a specific check-in date
    List<Booking> findByStayPeriodCheckInDate(LocalDateTime stayPeriod_checkInDate);

    //Find booking matching a booking channel(ONLINE, WALK_IN, PHONE)
    List<Booking> findByBookingChannel(BookingChannel bookingChannel);
}
