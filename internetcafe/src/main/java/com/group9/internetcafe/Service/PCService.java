// PCService.java
package com.group9.internetcafe.Service;

import com.group9.internetcafe.Entity.PC;
import com.group9.internetcafe.Repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public int getNumberOfVacantPCs() {
        // Implement as per your requirement
        return 0;
    }

    public void updatePCStatus(int id, String status) {
        // Implement as per your requirement
    }
}
