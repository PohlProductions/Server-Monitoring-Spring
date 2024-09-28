package de.pohlproductions.servermonitoring.repository;

import de.pohlproductions.servermonitoring.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {

}
