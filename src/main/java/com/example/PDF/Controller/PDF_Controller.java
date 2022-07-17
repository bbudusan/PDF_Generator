package com.example.PDF.Controller;

import com.example.PDF.Service.PDF_Generator_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDF_Controller {
    private final PDF_Generator_Service pdf_generator_service;

     public PDF_Controller(PDF_Generator_Service pdf_generator_service){
      this.pdf_generator_service=pdf_generator_service;
     }

     @GetMapping("pdf/generate")
    public void generate_PDF(HttpServletResponse response) throws IOException {
         response.setContentType("application/pdf");
         DateFormat dateFormatter=new SimpleDateFormat("dd-MM-yyyy");

         String currentDateTime= dateFormatter.format(new Date());

         String headerKey="Content-Disposition";
         String headerValue="attachment; filename=PDF_"+currentDateTime +".pdf";

         response.setHeader(headerKey,headerValue);
         this.pdf_generator_service.Export(response);

     }
}
