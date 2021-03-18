package com.cap.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.demo.entity.Trainee;

@Repository
public interface TraineeDao extends JpaRepository<Trainee, Integer> {
	

}
