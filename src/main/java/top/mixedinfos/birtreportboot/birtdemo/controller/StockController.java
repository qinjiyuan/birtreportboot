package top.mixedinfos.birtreportboot.birtdemo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mixedinfos.birtreportboot.birtconfig.BirtReportGenerator;
import top.mixedinfos.birtreportboot.birtconfig.ReportParameter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Api(description = "报表", tags = "report")
@RestController
@RequestMapping(value = "/report/test")
@Slf4j
public class StockController {

    @Autowired
    private  BirtReportGenerator birtReportGenerator;


    @ApiOperation(value = "PDF", notes = "PDF测试", httpMethod = "GET")
    @GetMapping("/stockPdf")
    public String  getStockPdf(){
        ReportParameter rm=new ReportParameter("stock_report","PDF");
        String base64 = "";
        try {
            ByteArrayOutputStream baos = birtReportGenerator.generate(rm);
            byte [] bytes = baos.toByteArray();
            base64 = byteToBase64(bytes);
            baos.close();
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
        }

        return  base64 ;
    }

    public String byteToBase64(byte[]bytes) throws IOException {
        String base64=  Base64Utils.encodeToString(bytes);
        return base64;
    }

}
