package com.devglan.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.ClaimDao;
import com.devglan.model.Claim;
import com.devglan.model.ClaimDto;
import com.devglan.service.ClaimService;

@Service(value = "claimService")
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimDao claimDao;

	@Override
	public Claim save(ClaimDto claimDto) {
		Claim claim = new Claim();
		claim.setBillDate(claimDto.getBillDate());
		claim.setBillNo(claimDto.getBillNo());
		claim.setCategory(claimDto.getCategory());
		claim.setClaimAmount(claimDto.getClaimAmount());
		claimDao.save(claim);
		return null;
	}

	@Override
	public List<Claim> findAll() {
		List<Claim> list = new ArrayList<>();
		List<Claim> resultList = new ArrayList<>();
		claimDao.findAll().iterator().forEachRemaining(list::add);
		for (Claim claim : list) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			claim.setBillDateString(sdf.format(claim.getBillDate()));
			resultList.add(claim);
		}
		return resultList;
	}

	@Override
	public void delete(int id) {
		claimDao.deleteById(id);

	}

	@Override
	public Claim findOne(int billNumber) {
		return claimDao.findByBillNo(billNumber);
	}

	@Override
	public Claim findById(int id) {
		Optional<Claim> claim = claimDao.findById(id);
		if (claim.isPresent())
			return claim.get();
		else
			return null;
	}

	@Override
	public ClaimDto update(ClaimDto claimdto) {
		Claim claim = findById(claimdto.getId());
		 if(claim != null) {
	            BeanUtils.copyProperties(claimdto, claim);
	            claimDao.save(claim);
	        }
	        return claimdto;
	}

}
