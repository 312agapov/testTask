package com.example.TestTask.service;

import com.example.TestTask.entity.HardDrive;
import com.example.TestTask.entity.HardDrive;
import com.example.TestTask.repository.HardDriveRepository;
import com.example.TestTask.repository.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HardDriveService {
    @Autowired
    private HardDriveRepository hardDriveRepository;

    public HardDrive addHardDrive(HardDrive hd){
        return hardDriveRepository.save(hd);
    }

    public List<HardDrive> findAllHardDrives(){
        return hardDriveRepository.findAll();
    }

    public Optional<HardDrive> findHardDriveByID(UUID id){
        Optional<HardDrive> optionalHD = hardDriveRepository.findById(id);
        if (optionalHD.isPresent()) {
            return hardDriveRepository.findById(id);
        } else {
            throw new IllegalArgumentException("HardDrive with ID " + id + " not found");
        }
    }

    public HardDrive editHardDrive(UUID id, HardDrive newHD){
        Optional<HardDrive> optionalHD = hardDriveRepository.findById(id);

        if (optionalHD.isPresent()){
            HardDrive existingHardDrive = optionalHD.get();
            existingHardDrive.setMaker(newHD.getMaker());
            existingHardDrive.setSerialNumber((newHD.getSerialNumber()));
            existingHardDrive.setPrice(newHD.getPrice());
            existingHardDrive.setCount(newHD.getCount());
            existingHardDrive.setCapacity(newHD.getCapacity());
            return hardDriveRepository.save(existingHardDrive);
        } else {
            throw new IllegalArgumentException("HardDrive with ID " + id + " not found");
        }
    }
}
