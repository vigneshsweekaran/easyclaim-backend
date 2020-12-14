package com.devglan.service;

import java.util.List;

import com.devglan.model.Claim;
import com.devglan.model.ClaimDto;

public interface ClaimService {

    Claim save(ClaimDto claim);
    List<Claim> findAll();
    void delete(int id);

    Claim findById(int id);

    ClaimDto update(ClaimDto claimdto);
	Claim findOne(int billNumber);
}
