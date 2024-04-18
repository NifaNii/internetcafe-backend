// PCService.java
package com.group9.internetcafe.Service;

import com.group9.internetcafe.Entity.PC;
import com.group9.internetcafe.Repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PCService {

    private final PCRepository pcRepository;

    @Autowired
    public PCService(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    public List<PC> getAllPCs() {
        return pcRepository.findAll();
    }
    
    public int getNumberOfPCsByStatus(String status) {
        List<PC> pcs = pcRepository.findByStatus(status);
        return pcs.size();
    }
    
    @SuppressWarnings("finally")
    public PC updatePCStatus(int id, PC newPC) {
        PC pc = new PC();
        
        try {
        	pc = pcRepository.findById(id).get();
        	
        	pc.setPcNumber(newPC.getPcNumber());
        	pc.setStatus(newPC.getStatus());
        }catch(NoSuchElementException ex) {
        	throw new NoSuchElementException("PC Number " + id + " does not exist");
        }finally {
        	return pcRepository.save(pc);
        }
    }
}
