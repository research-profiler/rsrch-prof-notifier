package com.notifier.service;

import com.notifier.model.Trigger;

import java.util.List;

public interface TriggerServiceImpl {

    List<Trigger> findAll();
    Trigger findById(Long id);
    Trigger save(Trigger trigger);
    void delete(Long id);


}
