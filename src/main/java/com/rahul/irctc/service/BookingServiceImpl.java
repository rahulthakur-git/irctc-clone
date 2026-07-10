package com.rahul.irctc.service;

import com.rahul.irctc.dto.BookingRequestDto;
import com.rahul.irctc.dto.BookingResponseDto;
import com.rahul.irctc.entity.Booking;
import com.rahul.irctc.entity.TrainSchedule;
import com.rahul.irctc.repository.BookingRepository;
import com.rahul.irctc.repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

public class BookingServiceImpl implements BookingService{


    @Override
    public BookingResponseDto bookTicket(BookingRequestDto bookingRequestDto) {
        TrainSchedule trainSchedule = trainScheduleRepository.findById(bookingRequestDto.getScheduleId())
                .orElseThrow(()-> new RuntimeException("Train Schedule Not Found"));

        if(trainSchedule.getAvailableSeats()< bookingRequestDto.getNumberOfSeats()){
            throw new RuntimeException("Not enough seats available");
        }
        Booking booking = new Booking();
        booking.setPassengerName(bookingRequestDto.getPassengerName());
        booking.setPassengerEmail(bookingRequestDto.getPassengerEmail());
        booking.setPassengerPhone(bookingRequestDto.getPassengerPhone());
        booking.setNumberOfSeats(bookingRequestDto.getNumberOfSeats());
        booking.setTrainSchedule(trainSchedule);
        booking.setBookingStatus("Confirmed");
//        "Setting Booking Time"
        booking.setBookingDate(LocalDateTime.now());
//        "Generate PNR number "
        String pnr = "PNR"+ System.currentTimeMillis();
        booking.setPnr(pnr);
//        "Reduce Seat Available "
        trainSchedule.setAvailableSeats(
                trainSchedule.getAvailableSeats() - bookingRequestDto.getNumberOfSeats()
        );
//        "Now we've changed the available seats"
        trainScheduleRepository.save(trainSchedule);
//        "Now save the booking"
        Booking savedBooking = bookingRepository.save(booking);

        BookingResponseDto response = new BookingResponseDto();

        response.setPnr(savedBooking.getPnr());
        response.setPassengerName(savedBooking.getPassengerName());

        response.setTrainNumber(savedBooking.getTrainSchedule().getTrain().getTrainNumber());
        response.setTrainName(savedBooking.getTrainSchedule().getTrain().getTrainName());

        response.setSource(savedBooking.getTrainSchedule().getTrain().getSource());
        response.setDestination(savedBooking.getTrainSchedule().getTrain().getDestination());

        response.setJourneyDate(savedBooking.getTrainSchedule().getJourneyDate());

        response.setBookedSeats(savedBooking.getNumberOfSeats());

        response.setBookingStatus(savedBooking.getBookingStatus());

        response.setBookingDate(savedBooking.getBookingDate());

        return response;
    }

    @Override
    public BookingResponseDto cancelBooking(String pnr) {
        Booking booking = bookingRepository.findByPnr(pnr)
                .orElseThrow(()-> new RuntimeException("Booking Not Found"));

        if ("CANCELLED".equals(booking.getBookingStatus())){
            throw new RuntimeException("Booking Already Cancelled ");
        }

        TrainSchedule trainSchedule = booking.getTrainSchedule();
        trainSchedule.setAvailableSeats(
                trainSchedule.getAvailableSeats()+booking.getNumberOfSeats()
        );
        booking.setBookingStatus("CANCELLED");
        trainScheduleRepository.save(trainSchedule);
        Booking updatedBooking = bookingRepository.save(booking);
        BookingResponseDto response = new BookingResponseDto();
        response.setPnr(updatedBooking.getPnr());
        response.setPassengerName(updatedBooking.getPassengerName());
        response.setTrainNumber(updatedBooking.getTrainSchedule().getTrain().getTrainNumber());
        response.setTrainName(updatedBooking.getTrainSchedule().getTrain().getTrainName());
        response.setSource(updatedBooking.getTrainSchedule().getTrain().getSource());
        response.setDestination(updatedBooking.getTrainSchedule().getTrain().getDestination());
        response.setJourneyDate(updatedBooking.getTrainSchedule().getJourneyDate());
        response.setBookedSeats(updatedBooking.getNumberOfSeats());
        response.setBookingStatus(updatedBooking.getBookingStatus());
        response.setBookingDate(updatedBooking.getBookingDate());


        return response;
    }

    private final BookingRepository bookingRepository;
    private final TrainScheduleRepository trainScheduleRepository;
    public BookingServiceImpl(BookingRepository bookingRepository, TrainScheduleRepository trainScheduleRepository) {
        this.bookingRepository = bookingRepository;
        this.trainScheduleRepository = trainScheduleRepository;
    }


}
