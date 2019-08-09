package com.filipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.repository.PointRepository;

@Service
public class PointService {
	
	@Autowired
	PointRepository pointRepository;
	
	
}
