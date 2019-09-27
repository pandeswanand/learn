package com.cg.springmvclab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springmvclab.dao.TraineeDao;
import com.cg.springmvclab.dto.Trainee;
@Service("traineeservice")
@Transactional
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	TraineeDao dao;
	@Override
	public Trainee addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return dao.save(trainee);
	}

	@Override
	public Trainee deleteTrainee(int id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return dao.update(trainee);
	}

	@Override
	public Trainee showTrainee(int id) {
		// TODO Auto-generated method stub
		return dao.show(id);
	}

	@Override
	public List<Trainee> showAllTrainee() {
		// TODO Auto-generated method stub
		return dao.showAll();
	}

}
