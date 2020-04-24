package com.notifier.controller;

import com.notifier.model.Trigger;
import com.notifier.model.User;
import com.notifier.service.EmailService;
import com.notifier.service.TriggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class showController {

    @Autowired
    private TriggerServiceImpl triggerService;

    @GetMapping("/showTriggers")
    public String findTriggers(Model model) {

        var triggers = (List<Trigger>) triggerService.findAll();

        model.addAttribute("triggers", triggers);

        return "showTriggers";
    }

    @RequestMapping("/showTriggers/delete/{id}")
	public String delete(@PathVariable Long id) {
		triggerService.delete(id);
		return "redirect:/showTriggers";
    }

    private Logger logger = LoggerFactory.getLogger(showController.class);
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/showTriggers/update")
	public String updateSuccess(){
        
        
		User user = new User();
		user.setFirstName("Ryan");
		user.setLastName("K");
		user.setEmailAddress("karrasrt@mail.uc.edu");
		
		try {
			emailService.sendEmail(user);
		}catch( MailException e ){

			logger.info("Error Sending Email: " + e.getMessage());
		}
		
		return "redirect:/showTriggers";
	}
    


}