package org.o7planning.thymeleaf.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalViewPrefix {

    @ModelAttribute("prefix")
    public String contextPath() {
        return RoutePrefix.CONTEXT_PATH;
    }
}
