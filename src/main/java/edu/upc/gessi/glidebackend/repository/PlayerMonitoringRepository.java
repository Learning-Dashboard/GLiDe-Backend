package edu.upc.gessi.glidebackend.repository;

import edu.upc.gessi.glidebackend.entity.IndividualPlayerEntity;
import edu.upc.gessi.glidebackend.entity.PlayerMonitoringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerMonitoringRepository extends JpaRepository<PlayerMonitoringEntity, String> {

    public PlayerMonitoringEntity findByIndividualPlayerEntity(IndividualPlayerEntity individualPlayerEntity);

}

