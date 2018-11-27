package com.example.demo.service.jpaService;

import com.example.demo.dataobject.jpaEntity.FAddress;

public interface AddressService {
     FAddress saveAddress(FAddress address);
     void flush();
     void remove(Long id);
}
