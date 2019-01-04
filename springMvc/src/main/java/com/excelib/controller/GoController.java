package com.excelib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 2019年1月4日12:33:16
 * from : 《看透Spring MVC: 源代码分析与实践》，第8章
 */
@Controller
public class GoController {
    private final Logger logger = LoggerFactory.getLogger(GoController.class);

    @RequestMapping(value = {"/"}, method = {RequestMethod.HEAD})
    public String head() {
        return "go.jsp";
    }

    @RequestMapping(value = {"/index", "/"}, method = {RequestMethod.GET})
    public String index(Model model) {
        logger.info("=== processed by index ===");
        model.addAttribute("msg", "Go Go Go!");
        return "go.jsp";
    }
}
