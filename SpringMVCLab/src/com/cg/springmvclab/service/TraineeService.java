package com.cg.springmvclab.service;

import java.util.List;

import com.cg.springmvclab.dto.Trainee;

public interface TraineeService {

	public Trainee addTrainee(Trainee trainee);
	public Trainee deleteTrainee(int id);
	public Trainee updateTrainee(Trainee trainee);
	public Trainee showTrainee(int id);
	public List<Trainee> showAllTrainee();
}
