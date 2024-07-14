package org.example.practice.Controller;

import org.example.practice.Table.BranchOfTheOrganization;
import org.example.practice.Service.BranchOfTheOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchOfTheOrganizationController {

    @Autowired
    private BranchOfTheOrganizationService branchService;

    @GetMapping
    public List<BranchOfTheOrganization> getAllBranches() {
        return branchService.findAll();
    }

    @GetMapping("/bi{id}")
    public BranchOfTheOrganization getBranchById(@PathVariable int id) {
        return branchService.findById(id);
    }

    @PostMapping("/s{id}")
    public void saveBranch(@RequestBody BranchOfTheOrganization branch) {
        branchService.save(branch);
    }

    @PutMapping("/{id}")
    public void updateBranch(@PathVariable int id, @RequestBody BranchOfTheOrganization branch) {
        branch.setId(id);
        branchService.update(branch);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable int id) {
        branchService.deleteById(id);
    }
}
