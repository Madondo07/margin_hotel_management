package za.ac.cput.marginhotelmanagement.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.marginhotelmanagement.domain.Booking;
import za.ac.cput.marginhotelmanagement.enums.BookingChannel;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    private Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking.Builder()
                .setBookingDate(LocalDate.of(2026, 7, 10))
                .setBookingChannel(BookingChannel.ONLINE)
                .build();
    }

    @Test
    void create() {
        Booking savedBooking = bookingRepository.save(booking);
        assertNotNull(savedBooking);
        assertNotNull(savedBooking.getBookingId());
        assertEquals(LocalDate.of(2026, 7, 10), savedBooking.getBookingDate());
        assertEquals(BookingChannel.ONLINE, savedBooking.getBookingChannel());
        System.out.println("Created: " + savedBooking);
    }

    @Test
    void read() {
        Booking savedBooking = bookingRepository.save(booking);

        Booking foundBooking = bookingRepository.findById(savedBooking.getBookingId()).orElse(null);

        assertNotNull(foundBooking);
        assertEquals(savedBooking.getBookingId(), foundBooking.getBookingId());
        assertEquals(savedBooking.getBookingDate(), foundBooking.getBookingDate());
        System.out.println("Read: " + foundBooking);
    }

    @Test
    void update() {
        Booking savedBooking = bookingRepository.save(booking);

        Booking updatedBooking = new Booking.Builder()
                .copy(savedBooking)
                .setBookingDate(LocalDate.of(2026, 7, 15))
                .setBookingChannel(BookingChannel.WALK_IN)
                .build();

        Booking result = bookingRepository.save(updatedBooking);

        assertNotNull(result);
        assertEquals(savedBooking.getBookingId(), result.getBookingId());
        assertEquals(LocalDate.of(2026, 7, 15), result.getBookingDate());
        assertEquals(BookingChannel.WALK_IN, result.getBookingChannel());
        System.out.println("Updated: " + result);
    }


    @Test
    @Disabled
    void delete() {
        Booking savedBooking = bookingRepository.save(booking);
        Long id = savedBooking.getBookingId();

        bookingRepository.delete(savedBooking);

        Booking deletedBooking = bookingRepository.findById(id).orElse(null);
        assertNull(deletedBooking);
        System.out.println("Deleted booking with ID: " + id);
    }


    @Test
    void findAll() {
        Booking booking2 = new Booking.Builder()
                .setBookingDate(LocalDate.of(2026, 7, 12))
                .setBookingChannel(BookingChannel.WALK_IN)
                .build();

        bookingRepository.save(booking);
        bookingRepository.save(booking2);

        List<Booking> bookings = bookingRepository.findAll();

        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
        System.out.println("All bookings: " + bookings);
    }
}