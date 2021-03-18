package com.cap.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cap.demo.service.TraineeService;
import com.cap.demo.entity.Trainee;
//demo app for github
@RestController
@RequestMapping("/trainee")
public class TraineeController { //http://localhost:1619/trainee/getTrainee/1001
	
	@Autowired
	TraineeService service;
	@RequestMapping("/getTrainee/{tid}")
	public Optional<Trainee> getTraineeById(@PathVariable("tid") int traineeId)
	{
		return service.getTraineeById(traineeId);
	}
	
	@RequestMapping("/getTrainee/all")
	public List<Trainee> showTrainee()
	{
		return service.showTrainee();
	}
	
	@PostMapping("/addTrainee")
	public int addTrainee(@RequestBody Trainee trainee) {
		service.addTrainee(trainee);
		return trainee.getTraineeId();
	}
	
	@PutMapping("/updateTrainee")
	public int updateTrainee(@RequestBody Trainee trainee) {
		service.updateTrainee(trainee);
		return trainee.getTraineeId();
	}
	
	@DeleteMapping("/deleteTrainee/{tid}")
	public String updateTrainee(@PathVariable("tid") int traineeId) {
		Optional<Trainee> trainee = service.getTraineeById(traineeId);
		service.removeTrainee(traineeId);
		return "Deleted:\n" + trainee;
	}
	@GetMapping("/getAllTrainees") // http://localhost:1234/trainee/updateTrainee
	public List<Trainee> fetchAllTrainees()// get,post,put,delete
	{
		return service.getAllTrainees();

	}
}