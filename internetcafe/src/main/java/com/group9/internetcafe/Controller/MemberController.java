package com.group9.internetcafe.Controller;

import com.group9.internetcafe.Entity.Member;
import com.group9.internetcafe.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/insertMember")
    public void insertMember(@RequestBody Member member) {
        memberService.insertMember(member);
    }

    @GetMapping("/getAllMembers")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/getMemberByID")
    public Member getMemberByID(@RequestParam int id) {
        return memberService.getMemberByID(id);
    }

    @PutMapping("/updateMember")
    public void updateMember(@RequestParam int id, @RequestBody Member member) {
        member.setId(id);
        memberService.updateMember(member);
    }
}
