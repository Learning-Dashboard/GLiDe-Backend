package edu.upc.gessi.glidebackend.repository;

import edu.upc.gessi.glidebackend.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
