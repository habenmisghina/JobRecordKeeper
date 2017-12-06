package com.job.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.modal.Employer;
import com.job.modal.Job;
import com.job.repository.JobRepository;



@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public Job recordJob(Job job) {
		job.setRegisteredDate(LocalDate.now());
		return jobRepository.save(job);
	}

	@Override
	public List<Job> getallJobs() {
		return jobRepository.findAll();
	}

	

	@Override
	public List<Job> getJobByRecruiter(Employer recruiter) {
		return jobRepository.findByRecruiter(recruiter);
	}

	@Override
	public List<Job> getJobByDirectHire(Employer directHire) {
		return jobRepository.findByDirectHire(directHire);
	}

	
	@Override
	public List<Job> getJobByDateApplied(LocalDate dateApplied) {
		return jobRepository.findByDateApplied(dateApplied);
	}

	@Override
	public List<Job> getJobByRegisteredDate(LocalDate registeredDate) {
		return jobRepository.findByRegisteredDate(registeredDate);
	}

}