package com.notifier.repository;

import com.notifier.model.Trigger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerRepository extends CrudRepository<Trigger, Long> {

}