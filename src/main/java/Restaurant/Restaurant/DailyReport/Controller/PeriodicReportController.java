package Restaurant.Restaurant.DailyReport.Controller;

import Restaurant.Restaurant.DailyReport.Model.DailyReport;
import Restaurant.Restaurant.DailyReport.Model.PeriodicReport;
import Restaurant.Restaurant.DailyReport.Service.DailyReportService;
import Restaurant.Restaurant.DailyReport.Service.PeriodicReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("admin/report")
public class PeriodicReportController {

    @Autowired
    PeriodicReportService periodicReportService;

    @Autowired
    DailyReportService dailyReportService;

    @GetMapping("/periodicReportPage")
    public String getPeriodicReportHomepage(){

        return "report/periodicReportHomepage";
    }

    @PostMapping("/getReportByDate")
    public String getReportByDate(@RequestParam String begin,
                                  @RequestParam String end,
                                  Model model){

        LocalDate localDateBegin = LocalDate.parse(begin);
        LocalDate localDateEnd = LocalDate.parse(end);

        PeriodicReport currentPeriodicReport = new PeriodicReport(localDateBegin, localDateEnd);

        List<DailyReport> listDailyReportsBetweenDates = dailyReportService.getDailyReportBetween(localDateBegin,localDateEnd);
        currentPeriodicReport.setListDailyReports(listDailyReportsBetweenDates);
        currentPeriodicReport.update();
        System.out.println("price: "+currentPeriodicReport.getDish_price());
        System.out.println("quantity: "+currentPeriodicReport.getDish_quantity());

        System.out.println("ile raportów: "+listDailyReportsBetweenDates.size());

        if(listDailyReportsBetweenDates.size()>0){
            model.addAttribute("listReports", listDailyReportsBetweenDates);
            model.addAttribute("sumReport", currentPeriodicReport);
        }

        System.out.println("LocalDate od: = "+localDateBegin+",    do: "+localDateEnd);
        return "report/periodicReportHomepage";
    }


}
