package com.project.service;

import com.project.model.Kart;
import com.project.repository.KartRepository;
import java.util.List;

public class KartService {
    private KartRepository kartRepository;

    public KartService(KartRepository kartRepository) {
        this.kartRepository = kartRepository;
    }

    public List<Kart> getAllKarts() {
        return kartRepository.retrieveKarts();
    }

    public void addKart(Kart kart) {
        kartRepository.createKart(kart);
    }

    public void updateKart(Kart kart) {
        kartRepository.updateKart(kart);
    }

    public void removeKart(long id) {
        kartRepository.deleteKart(id);
    }
}
