package com.cg.springmvclab.dao;

import java.util.List;

import com.cg.springmvclab.dto.Trainee;

public interface TraineeDao {

	public Trainee save(Trainee trainee);
	public Trainee remove(int id);
	public Trainee update(Trainee trainee);
	public Trainee show(int id);
	public List<Trainee> showAll();
}
