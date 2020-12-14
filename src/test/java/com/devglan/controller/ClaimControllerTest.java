package com.devglan.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.devglan.model.ApiResponse;
import com.devglan.model.Claim;
import com.devglan.model.ClaimDto;
import com.devglan.service.ClaimService;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimControllerTest {

	@MockBean
	private ClaimService claimService;
	
	@Autowired
	ClaimController claimController;
	
	@Before
	public void setup() {
		Claim claim = new Claim();
		claim.setId(1);
		claim.setBillNo(123);
		claim.setClaimAmount(1000d);
		List<Claim> resultList = new ArrayList<Claim>();
		resultList.add(claim);
		Mockito.when(claimService.save(Mockito.any())).thenReturn(claim);
		Mockito.when(claimService.findAll()).thenReturn(resultList);
		Mockito.when(claimService.findById(Mockito.anyInt())).thenReturn(claim);
		Mockito.when(claimService.update(Mockito.any())).thenReturn(new ClaimDto());
	}
	
	@Test
	public void saveClaimTest() {
		ApiResponse<Claim> response = claimController.saveClaim(new ClaimDto());
		Assert.assertEquals(1000d, ((Claim) response.getResult()).getClaimAmount());
	}
	
	@Test
	public void listAllClaimsTest() {
		ApiResponse<List<Claim>> response = claimController.listAllClaims();
		Assert.assertEquals(1000d, ((List<Claim>) response.getResult()).get(0).getClaimAmount());
	}
	
	@Test
	public void getOneTest() {
		ApiResponse<Claim> response = claimController.getOne(1);
		Assert.assertEquals(1000d, ((Claim) response.getResult()).getClaimAmount());
	}
	
	@Test
	public void updateTest() {
		ApiResponse<ClaimDto> response = claimController.update(new ClaimDto());
		Assert.assertEquals("User updated successfully.", response.getMessage());
	}
	
	@Test
	public void deleteTest() {
		ApiResponse<Void> response = claimController.delete(1);
		Assert.assertEquals("User deleted successfully.", response.getMessage());
	}
}
