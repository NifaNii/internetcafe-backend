package com.group9.internetcafe.Service;

import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9.internetcafe.Entity.MembersEntity;
import com.group9.internetcafe.Repository.MembersRepository;

@Service
public class MembersService {

	@Autowired
    MembersRepository memberRepository;

    public void insertMember(MembersEntity member) {
        memberRepository.save(member);
    }

    public List<MembersEntity> getAllMembers() {
        return memberRepository.findAll();
    }

    public MembersEntity getMemberByID(int id) {
//        Optional<MembersEntity> optionalMember = memberRepository.findById(id);
//        
//        if (optionalMember.isPresent()) {
//            return optionalMember.get(); 
//        } else {
//            
//            throw new IllegalArgumentException("Member not found for ID: " + id);
//        }
    	MembersEntity member = new MembersEntity();
    	member = memberRepository.findById(id).get();
    	
    	return member;
    }


    @SuppressWarnings("finally")
    public MembersEntity updateMember(int id, MembersEntity newmember) {
    	MembersEntity member = new MembersEntity();
    	try {
    		member = memberRepository.findById(id).get();
    		
    		member.setUsername(newmember.getUsername());
    		member.setFirstname(newmember.getFirstname());
    		member.setLastname(newmember.getLastname());
    		member.setPassword(newmember.getPassword());
    		member.setBalance(newmember.getBalance());
    	}catch (NoSuchElementException ex) {
    		throw new NoSuchElementException("Member id " + id + " does not exists.");
    	}finally {
    		return memberRepository.save(member);
    	}
    }
    
    // Advanced Settings
    public int checkLoginCredentials(String username, String password) {
    	MembersEntity member = memberRepository.findByUsername(username);
    	
    	if(member != null && member.getPassword().equals(password)) {
    		return member.getId();
    	}else {
    		return -1;
    	}
    }
    
    // check if admin
    public int checkAdmin(String username, String password) {
    	MembersEntity member = memberRepository.findByUsername(username);
    	
    	if(member != null && member.getPassword().equals(password)) {
    		if(member.getAdmin() == 1){
    			return member.getId();
        	}else {
        		return -2;
        	}
    	}else {
    		return -1;
    	}
    }
}
