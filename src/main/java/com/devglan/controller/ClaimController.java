package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.ApiResponse;
import com.devglan.model.Claim;
import com.devglan.model.ClaimDto;
import com.devglan.service.ClaimService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ApiResponse<Claim> saveClaim(@RequestBody ClaimDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "Claim details saved successfully.",claimService.save(user));
    }

    @GetMapping
    public ApiResponse<List<Claim>> listAllClaims(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Claim list fetched successfully.",claimService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Claim> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",claimService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<ClaimDto> update(@RequestBody ClaimDto claimDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",claimService.update(claimDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        claimService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
