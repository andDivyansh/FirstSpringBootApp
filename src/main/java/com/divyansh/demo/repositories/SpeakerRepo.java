package com.divyansh.demo.repositories;

import com.divyansh.demo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
}
