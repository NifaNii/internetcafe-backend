package com.group9.internetcafe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group9.internetcafe.Entity.MembersEntity;
import com.group9.internetcafe.Service.MembersService;

@RestController
@RequestMapping("/member")
public class MembersController {

	@Autowired
    MembersService memberService;
    
    @PostMapping("/insertMember")
    public void insertMember(@RequestBody MembersEntity member) {
        memberService.insertMember(member);
    }

    @GetMapping("/getAllMembers")
    public List<MembersEntity> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/getMemberByID")
    public MembersEntity getMemberByID(@RequestParam int id) {
        return memberService.getMemberByID(id);
    }

    @PutMapping("/updateMember")
    public void updateMember(@RequestParam int id, @RequestBody MembersEntity member) {
        memberService.updateMember(id, member);
    }
}
