package Restaurant.Restaurant.DailyReport.Service;

import Restaurant.Restaurant.DailyReport.Model.DailyReport;
import Restaurant.Restaurant.DailyReport.Repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DailyReportServiceImpl implements DailyReportService {

    @Autowired
    DailyReportRepository dailyReportRepository;

    @Override
    public Optional<DailyReport> getDailyReportById(Long id) {
        return dailyReportRepository.findById(id);
    }

    @Override
    public DailyReport getDailyReportByDay(LocalDateTime localDateTime)  {

        LocalDateTime begin = LocalDateTime.of(localDateTime.toLocalDate(),LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(localDateTime.toLocalDate(),LocalTime.MAX);

        return dailyReportRepository.findByDate(localDateTime.toLocalDate());
    }

    @Override
    public List<DailyReport> getAll() {
        return dailyReportRepository.findAll();
    }

    @Override
    public void addDailyReport(DailyReport dailyReport) {
        dailyReportRepository.save(dailyReport);
    }
}
