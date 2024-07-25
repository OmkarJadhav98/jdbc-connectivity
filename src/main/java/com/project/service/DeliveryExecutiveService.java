package com.project.service;

import com.project.model.DeliveryExecutive;
import com.project.repository.DeliveryExecutiveRepository;
import java.util.List;

public class DeliveryExecutiveService {
    private final DeliveryExecutiveRepository deliveryExecutiveRepository;

    public DeliveryExecutiveService(DeliveryExecutiveRepository deliveryExecutiveRepository) {
        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
    }

    public List<DeliveryExecutive> getAllDeliveryExecutives() {
        return deliveryExecutiveRepository.retrieveDeliveryExecutives();
    }

    public void addDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.createDeliveryExecutive(deliveryExecutive);
    }

    public void updateDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.updateDeliveryExecutive(deliveryExecutive);
    }

    public void removeDeliveryExecutive(long id) {
        deliveryExecutiveRepository.deleteDeliveryExecutive(id);
    }
}
