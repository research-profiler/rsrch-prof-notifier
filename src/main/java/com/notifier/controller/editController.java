package com.notifier.controller;

import com.notifier.model.Trigger;
import com.notifier.service.TriggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class editController {

    @Autowired
    private TriggerServiceImpl triggerService;

    Logger log = LoggerFactory.getLogger(this.getClass());



    @RequestMapping("/editTriggers/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
        model.addAttribute("triggers", triggerService.findById(id));
        triggerService.delete(id);
        return "editTriggers";
    }
    
    @PostMapping("/editTriggers")
    public String TriggerSubmit(@ModelAttribute Trigger triggers, Model model) {
      
        model.addAttribute("triggers", triggers);
        String info = String.format("Notifier Submission: nname = %s,  researcher = %s, bucket = %s, college = %s", 
                        triggers.getNname(), triggers.getResearcher(), triggers.getBucket(), triggers.getCollege());

        log.info(info);
        triggerService.save(triggers);
                
        return "redirect:showTriggers";
    }


}