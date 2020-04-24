package com.notifier.controller;

import com.notifier.model.Trigger;
import com.notifier.service.TriggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class addController {

    @Autowired
    private TriggerServiceImpl triggerService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/addTriggers")
    public String triggerForm(Model model) {

        model.addAttribute("triggers", new Trigger());

        return "addTriggers";
        
    }



    @PostMapping("/addTriggers")
    public String TriggerSubmit(@ModelAttribute Trigger triggers, Model model) {
      
        model.addAttribute("triggers", triggers);
        String info = String.format("Notifier Submission: nname = %s,  researcher = %s, bucket = %s, college = %s", 
                        triggers.getNname(), triggers.getResearcher(), triggers.getBucket(), triggers.getCollege());

        log.info(info);
        triggerService.save(triggers);
                
        return "redirect:showTriggers";
    }



}