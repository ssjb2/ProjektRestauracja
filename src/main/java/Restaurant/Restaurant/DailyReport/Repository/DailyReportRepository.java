package Restaurant.Restaurant.DailyReport.Repository;

import Restaurant.Restaurant.DailyReport.Model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {

    DailyReport findByDate(LocalDate localDate);

    //    List<DailyReport> findByDateBetween(LocalDateTime dayBegin, LocalDateTime dayEnd);
}
