package Restaurant.Restaurant.DailyReport.Controller;

import Restaurant.Restaurant.DailyReport.Model.DailyReport;
import Restaurant.Restaurant.DailyReport.Service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin/report")
public class DailyReportController {

    @Autowired
    DailyReportService dailyReportService;

    @GetMapping("/dailyReportPage")
    public String daliyReportPage(Model model){

        model.addAttribute("allDailyReports", dailyReportService.getAll());

        return "report/daily_homepage";
    }

    @GetMapping("/getDailyReport/{id}")
    public String getDailyReport(@PathVariable Long id,
                                 Model model){

        Optional<DailyReport> optDailyReport = dailyReportService.getDailyReportById(id);
        DailyReport currentDailyReport = null;

        if(optDailyReport.isPresent()){
            currentDailyReport = optDailyReport.get();
            model.addAttribute("dailyReport",currentDailyReport);
        }
        model.addAttribute("allDailyReports", dailyReportService.getAll());
        return "report/daily_homepage";

    }




}
