package com.christ.ffms.control;

import com.christ.ffms.service.ItemService;
import com.christ.ffms.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class ReportController {
    @Autowired
    ItemService itemService;
    @RequestMapping("toReportBbtj")
    public String toReportBbtj(){
        return "/report/bbtj";
    }
    @RequestMapping("toReportBbtj_01")
    public ModelAndView toReportBbtj_01(){
        ModelAndView modelAndView=new ModelAndView("/report/bbtj_01","items",itemService.getPItems());
        return modelAndView;
    }
    @RequestMapping("toReportBbtj_02")
    public String toReportBbtj_02(){
        return "/report/bbtj_02";
    }
}
