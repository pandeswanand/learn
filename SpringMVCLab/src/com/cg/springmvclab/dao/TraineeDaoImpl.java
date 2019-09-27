package com.cg.springmvclab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvclab.dto.Trainee;
@Repository("traineedao")
public class TraineeDaoImpl implements TraineeDao{

	@PersistenceContext
	EntityManager manager;
	@Override
	public Trainee save(Trainee trainee) {
		// TODO Auto-generated method stub
		manager.persist(trainee);
		return trainee;
	}

	@Override
	public Trainee remove(int id) {
		// TODO Auto-generated method stub
		Trainee trainee = manager.find(Trainee.class, id);
		manager.remove(trainee);
		return trainee;
	}

	@Override
	public Trainee update(Trainee trainee) {
		// TODO Auto-generated method stub
		Trainee updateTrainee = manager.find(Trainee.class, trainee.getTraineeId());
		updateTrainee.setTraineeName(trainee.getTraineeName());
		updateTrainee.setTraineeLocation(trainee.getTraineeLocation());
		updateTrainee.setTraineeDomain(trainee.getTraineeDomain());
		return trainee;
	}

	@Override
	public Trainee show(int id) {
		// TODO Auto-generated method stub
		Trainee trainee = manager.find(Trainee.class, id);
		return trainee;
	}

	@Override
	public List<Trainee> showAll() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("From Trainee");
		List<Trainee> list = query.getResultList();
		return list;
	}

}
