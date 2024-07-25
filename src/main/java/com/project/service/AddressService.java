package com.project.service;

import com.project.model.Address;
import com.project.repository.AddressRepository;

import java.util.List;

public class AddressService {
    private final AddressRepository addressRepository = new AddressRepository();

    /**
     * Retrieve a list of addresses.
     *
     * @return A list of Address objects.
     */
    public List<Address> retrieveAddresses() {
        return addressRepository.retrieveAddresses();
    }

    /**
     * Add a new address.
     *
     * @param address The Address object to be added.
     */
    public void createAddress(Address address) {
        addressRepository.createAddress(address);
    }

    /**
     * Update an existing address.
     *
     * @param address The Address object with updated information.
     */
    public void updateAddress(Address address) {
        addressRepository.updateAddress(address);
    }

    /**
     * Delete an address by ID.
     *
     * @param id The ID of the address to be deleted.
     */
    public void deleteAddress(long id) {
        addressRepository.deleteAddress(id);
    }

    /**
     * Find an address by ID.
     *
     * @param id The ID of the address to find.
     * @return The Address object if found, otherwise null.
     */
    public Address findById(long id) {
        return addressRepository.findById(id);
    }
}
