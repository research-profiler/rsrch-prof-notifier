package com.notifier.service;

import com.notifier.model.Trigger;
import com.notifier.repository.TriggerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriggerService implements TriggerServiceImpl {

    @Autowired
    private TriggerRepository repository;

    @Override
    public List<Trigger> findAll() {

        var triggers = (List<Trigger>) repository.findAll();

        return triggers;
    }

    @Override
    public Trigger findById(Long id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Trigger save(Trigger trigger) {
        repository.save(trigger);
        return trigger;
    }



}