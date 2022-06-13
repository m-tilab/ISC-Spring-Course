package org.example.controller;

import org.example.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
    public String displayForm() {

        return "fileUploadForm";
    }

//    public ModelAndView displayForm() {
//
//        final ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setView("fileUploadForm");
//        modelAndView.addObject()
//
//        //model.addAttribute()
//        return "fileUploadForm";
//    }


    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String submit(@ModelAttribute FormData formData, ModelMap modelMap) {

        modelMap.addAttribute("formData", formData);

        return "fileUploadView";

    }


}
