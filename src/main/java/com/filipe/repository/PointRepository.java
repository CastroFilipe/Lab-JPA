package com.filipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.model.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

}
