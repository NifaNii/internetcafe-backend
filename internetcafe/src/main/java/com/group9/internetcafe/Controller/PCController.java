// PCController.java
package com.group9.internetcafe.Controller;

import com.group9.internetcafe.Entity.PC;
import com.group9.internetcafe.Service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pc")
@CrossOrigin
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
    
    @GetMapping("/getNumberOfPCs/{status}")
    public int getNumberOfPCsByStatus(@PathVariable String status) {
        return pcService.getNumberOfPCsByStatus(status);
    }

    @PutMapping("/updatePCStatus")
    public void updatePCStatus(@RequestParam int id, @RequestBody PC newPC) {
        pcService.updatePCStatus(id, newPC);
    }
    
    @PutMapping("/loggedInUser")
    public void loggedInUser(@RequestParam int id, @RequestBody PC newPC) {
        pcService.loggedInUser(id, newPC);
    }
}
