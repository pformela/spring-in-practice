package project.springinpractice.member;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Member() {}

    public Member(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
    }
}
