package com.challenge.SpringHibernateChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.SpringHibernateChallenge.entities.Surf;

@Repository
public interface SurfDao extends JpaRepository<Surf, Long> {
}