package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.jpaEntity.FAddress;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.jpaService.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public FAddress saveAddress(FAddress address) {
        return addressRepository.save(address);
    }

    @Override
    public void flush() {
        addressRepository.flush();
    }

    @Override
    public void remove(Long id) {
        addressRepository.delete(id);
    }
}
