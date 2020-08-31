package com.divyansh.demo.repositories;

import com.divyansh.demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {
}
