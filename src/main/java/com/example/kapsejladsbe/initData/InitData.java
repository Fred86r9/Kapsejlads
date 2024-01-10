package com.example.kapsejladsbe.initData;

import com.example.kapsejladsbe.model.Sailboat;
import com.example.kapsejladsbe.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private SailboatRepository sailboatRepository;

    @Override
    public void run(String... args) throws Exception {
        Sailboat bigBoat = new Sailboat();
        bigBoat.setBoatType("+40feet");
        sailboatRepository.save(bigBoat);

        Sailboat medBoat = new Sailboat();
        medBoat.setBoatType("25-40feet");
        sailboatRepository.save(medBoat);

        Sailboat smallBoat = new Sailboat();
        smallBoat.setBoatType("-20feet");
        sailboatRepository.save(smallBoat);
    }
}
