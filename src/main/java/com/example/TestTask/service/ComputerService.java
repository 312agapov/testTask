package com.example.TestTask.service;

import com.example.TestTask.entity.Computer;
import com.example.TestTask.entity.Product;
import com.example.TestTask.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public Computer addComputer(Computer pc){
        return computerRepository.save(pc);
    }

    public List<Computer> findAllComputers(){
        return computerRepository.findAll();
    }

    public Optional<Computer> findComputerByID(UUID id){
        Optional<Computer> optionalPC = computerRepository.findById(id);
        if (optionalPC.isPresent()) {
            return computerRepository.findById(id);
        } else {
            throw new IllegalArgumentException("Computer with ID " + id + " not found");
        }
    }

    public Computer editComputer(UUID id, Computer newPC){
        Optional<Computer> optionalPC = computerRepository.findById(id);

        if (optionalPC.isPresent()){
            Computer existingComputer = optionalPC.get();
            existingComputer.setMaker(newPC.getMaker());
            existingComputer.setSerialNumber((newPC.getSerialNumber()));
            existingComputer.setPrice(newPC.getPrice());
            existingComputer.setCount(newPC.getCount());
            existingComputer.setFormFactor(newPC.getFormFactor());
            return computerRepository.save(existingComputer);
        } else {
            throw new IllegalArgumentException("Computer with ID " + id + " not found");
        }
    }
}
