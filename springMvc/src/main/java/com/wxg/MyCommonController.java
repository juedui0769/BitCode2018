package com.wxg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyCommonController {
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(RedirectAttributes attr) {
        RequestAttributes reqAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) reqAttributes;
        HttpServletRequest request = requestAttributes.getRequest();
        Object attribute = request.getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE);
        FlashMap flashMap = (FlashMap) attribute;

        flashMap.put("name", "张三丰");
        attr.addFlashAttribute("ordersId", "xxx");
        attr.addAttribute("local", "zh-cn");

        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        outputFlashMap.put("age", 130);

        return "redirect:showorders";
    }

    @RequestMapping(value = "/showorders", method = RequestMethod.GET)
    public String showOrders(Model model) {
        // doSomthing ...
        return "orders";
    }
}
