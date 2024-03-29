package com.casestudy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.casestudy.util.TrainInfoDto;


@FeignClient(value="TRAIN-DETAILS",url="localhost:8900")
public interface TrainDetailProxy {
	
	@GetMapping("/train/find")
	public TrainInfoDto getTrain(@RequestParam int trainNo);
	
	@PutMapping("/train/updateAcSeat/{trainNo}/{status}")
	public void updateAcSeat(@PathVariable int trainNo,@PathVariable String status);
	
	@PutMapping("/train/updateSlSeat/{trainNo}/{status}")
	public void updateSlSeat(@PathVariable int trainNo,@PathVariable String status);
	
	@PutMapping("/train/cancelacseat/{trainNo}")
	public void cancelAcTicket(@PathVariable int trainNo);
	
	@PutMapping("/train/cancelslseat/{trainNo}")
	public void cancelSlTicket(@PathVariable int trainNo);
}
