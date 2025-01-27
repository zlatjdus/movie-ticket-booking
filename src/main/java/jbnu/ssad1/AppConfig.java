package jbnu.ssad1;

import jbnu.ssad1.medel.entity.Movie;
import jbnu.ssad1.medel.entity.Screening;
import jbnu.ssad1.repository.booking.BookingRepository;
import jbnu.ssad1.repository.booking.MemoryBookingRepository;
import jbnu.ssad1.repository.member.MemberRepository;
import jbnu.ssad1.repository.member.MemoryMemberRepository;
import jbnu.ssad1.repository.movie.MemoryMovieRepository;
import jbnu.ssad1.repository.movie.MovieRepository;
import jbnu.ssad1.repository.payment.MemoryPaymentRepository;
import jbnu.ssad1.repository.payment.PaymentRepository;
import jbnu.ssad1.repository.review.MemoryReviewRepository;
import jbnu.ssad1.repository.review.ReviewRepository;
import jbnu.ssad1.repository.screening.MemoryScreeningRepository;
import jbnu.ssad1.repository.screening.ScreeningRepository;
import jbnu.ssad1.service.booking.BookingService;
import jbnu.ssad1.service.booking.BookingServiceImpl;
import jbnu.ssad1.service.member.MemberService;
import jbnu.ssad1.service.member.MemberServiceImpl;
import jbnu.ssad1.service.movie.MovieService;
import jbnu.ssad1.service.movie.MovieServiceImpl;
import jbnu.ssad1.service.payment.PaymentService;
import jbnu.ssad1.service.payment.PaymentServiceImpl;
import jbnu.ssad1.service.review.ReviewService;
import jbnu.ssad1.service.review.ReviewServiceImpl;
import jbnu.ssad1.service.screening.ScreeningService;
import jbnu.ssad1.service.screening.ScreeningServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AppConfig {
    private final MovieRepository movieRepository = new MemoryMovieRepository();
    private final ScreeningRepository screeningRepository = new MemoryScreeningRepository();

    public AppConfig() {
        Movie movie1 = new Movie(
                "서울의 봄",
                "김성수",
                Arrays.asList("황정민", "정우성", "이성민", "박해준", "김성균", "김의성"),
                LocalDate.of(2023, 11, 22),
                9.57,
                true
        );
        Movie movie2 = new Movie(
                "말하고 싶은 비밀",
                "타케무라 켄타로",
                Arrays.asList("타카하시 후미야", "사쿠라다 히요리"),
                LocalDate.of(2023, 12, 13),
                null,
                false
        );

        movieRepository.save(movie1);
        movieRepository.save(movie2);

        Screening screening1 = new Screening(movie1, LocalDateTime.of(2023, 12, 12, 9, 0));
        Screening screening2 = new Screening(movie1, LocalDateTime.of(2023, 12, 12, 12, 0));
        Screening screening3 = new Screening(movie1, LocalDateTime.of(2023, 12, 12, 15, 0));
        Screening screening4 = new Screening(movie1, LocalDateTime.of(2023, 12, 12, 18, 0));
        Screening screening5 = new Screening(movie1, LocalDateTime.of(2023, 12, 12, 21, 0));

        screeningRepository.save(screening1);
        screeningRepository.save(screening2);
        screeningRepository.save(screening3);
        screeningRepository.save(screening4);
        screeningRepository.save(screening5);
    }

    public BookingService bookingService() {
        return new BookingServiceImpl(bookingRepository());
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MovieService movieService() {
        return new MovieServiceImpl(movieRepository());
    }

    public PaymentService paymentService() {
        return new PaymentServiceImpl(paymentRepository());
    }

    public ReviewService reviewService() {
        return new ReviewServiceImpl(reviewRepository());
    }

    public ScreeningService screeningService() {
        return new ScreeningServiceImpl(screeningRepository());
    }

    public BookingRepository bookingRepository() {
        return new MemoryBookingRepository();
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MovieRepository movieRepository() {
        return movieRepository;
    }

    public PaymentRepository paymentRepository() {
        return new MemoryPaymentRepository();
    }

    public ReviewRepository reviewRepository() {
        return new MemoryReviewRepository();
    }

    public ScreeningRepository screeningRepository() {
        return screeningRepository;
    }
}
