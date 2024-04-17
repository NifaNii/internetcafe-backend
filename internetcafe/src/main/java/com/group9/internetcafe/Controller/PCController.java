// PCController.java
package com.group9.internetcafe.Controller;

import com.group9.internetcafe.Entity.PC;
import com.group9.internetcafe.Service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pc")
public class PCController {

    private final PCService pcService;

    @Autowired
    public PCController(PCService pcService) {
        this.pcService = pcService;
    }

    @GetMapping("/getAllPC")
    public List<PC> getAllPCs() {
        return pcService.getAllPCs();
    }

    @GetMapping("/getNumberOfVacants")
    public int getNumberOfVacantPCs() {
        return pcService.getNumberOfVacantPCs();
    }

    @PutMapping("/updatePCStatus")
    public void updatePCStatus(@RequestParam int id, @RequestParam String status) {
        pcService.updatePCStatus(id, status);
    }
}
