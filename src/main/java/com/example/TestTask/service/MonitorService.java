package com.example.TestTask.service;

import com.example.TestTask.entity.Monitor;
import com.example.TestTask.entity.Monitor;
import com.example.TestTask.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository monitorRepository;

    public Monitor addMonitor(Monitor monitor){
        return monitorRepository.save(monitor);

    }

    public List<Monitor> findAllMonitors(){
        return monitorRepository.findAll();
    }

    public Optional<Monitor> findMonitorByID(UUID id){
        Optional<Monitor> optionalPC = monitorRepository.findById(id);
        if (optionalPC.isPresent()) {
            return monitorRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Monitor with ID " + id + " not found");
        }
    }

    public Monitor editMonitor(UUID id, Monitor newMonitor){
        Optional<Monitor> optionalMonitor = monitorRepository.findById(id);

        if (optionalMonitor.isPresent()){
            Monitor existingMonitor = optionalMonitor.get();
            existingMonitor.setMaker(newMonitor.getMaker());
            existingMonitor.setSerialNumber((newMonitor.getSerialNumber()));
            existingMonitor.setPrice(newMonitor.getPrice());
            existingMonitor.setCount(newMonitor.getCount());
            existingMonitor.setDiagonal(newMonitor.getDiagonal());
            return monitorRepository.save(existingMonitor);
        } else {
            throw new IllegalArgumentException("Monitor with ID " + id + " not found");
        }
    }
}
