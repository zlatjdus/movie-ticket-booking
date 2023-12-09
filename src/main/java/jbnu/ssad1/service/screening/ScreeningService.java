package jbnu.ssad1.service.screening;

import jbnu.ssad1.medel.entity.Screening;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningService {
    Screening findScreeningById(Long screeningId);

    List<Screening> findAllScreening();

    List<Screening> findNotStartedScreenings(LocalDateTime now);
}