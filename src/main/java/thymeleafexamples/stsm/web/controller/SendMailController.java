package thymeleafexamples.stsm.web.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring3.SpringTemplateEngine;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by anatoliy on 14.04.14.
 */
@Controller
public class SendMailController {
    @Autowired
    private SpringTemplateEngine templateEngine;

    @RequestMapping("/create")
    @ResponseBody
    public HttpEntity<String> createMessage(HttpServletResponse response, Model model){
        Context ctx = new Context();
        ctx.setVariable("name", "Vasiya Pupkin");
        ctx.setVariable("subscriptionDate", new Date());
        String htmlContent = this.templateEngine.process("mes_template.html", ctx);
        response.setCharacterEncoding("UTF-8");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
        HttpEntity<String> httpResponse = new HttpEntity<String>(htmlContent, httpHeaders);
        return httpResponse;
    }
}
