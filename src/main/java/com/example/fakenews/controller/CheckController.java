package com.example.fakenews.controller;

import com.example.fakenews.entity.Check;
import com.example.fakenews.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check/")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping
    public Check saveCheck(@RequestBody Check check) {
        return checkService.saveCheck(check);
    }

    @PostMapping("/checks")
    public List<Check> addChecks(@RequestBody List<Check> check) {
        return checkService.saveChecks(check);
    }

    @GetMapping
    public List<Check> getAllChecks() {
        return checkService.getAllChecks();
    }

    @GetMapping("{checkId}")
    public Check getCheck(@PathVariable(name = "checkId") Long checkId) {
        return checkService.getCheck(checkId);
    }

    @PutMapping()
    public Check updateCheck(@RequestBody Check check) {
        return checkService.updateCheck(check);
    }

    @DeleteMapping("/delete/{checkId}")
    public void deleteCheck(@PathVariable(name = "checkId") Long checkId) {
        checkService.deleteCheck(checkId);
    }
}
