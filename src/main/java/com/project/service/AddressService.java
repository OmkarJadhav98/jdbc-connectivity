
package com.project.service;

import com.project.model.Address;
import com.project.repository.AddressRepository;

import java.util.List;

public class AddressService {

    private static final AddressRepository ADDRESS_REPO = new AddressRepository();

    public List<Address> retrieveAddresses() {
        return ADDRESS_REPO.retrieveAddresses();
    }
}
