package project.springinpractice.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.springinpractice.member.Member;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/nominate")
public final class NomineeController {

    private String thanksViewName;

    public void setThanksViewName(String thanksViewName) {
        this.thanksViewName = thanksViewName;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("nominee", new Member());
        return "form";
    }

    @PostMapping
    public String processFormData(
            @ModelAttribute("nominee") Member member,
            Model model) {
        log.info("Przetwarzanie informacji: " + member);
        Map map = model.asMap();
        log.info("model[member] = " + map.get("member"));
        log.info("model[nominee] = " + map.get("nominee"));
        return "thanks";
    }
}
