package project.springinpractice.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/members")
public class RosterController {

    private List<Member> members = Arrays.asList(
            new Member("John", "Lennon"),
            new Member("Paul", "McCartney"),
            new Member("George", "Harrison"),
            new Member("Ringo", "Starr")
    );

    public RosterController() {
//        members.add(new Member("John", "Lennon"));
//        members.add(new Member("Paul", "McCartney"));
//        members.add(new Member("George", "Harrison"));
//        members.add(new Member("Ringo", "Starr"));
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", members);
        return "list";
    }

    @GetMapping("/{id}")
    public String member(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("member", members.get(id));
        return "member";
    }
}
