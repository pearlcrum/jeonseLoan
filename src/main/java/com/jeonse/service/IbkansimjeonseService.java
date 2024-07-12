package com.jeonse.service;

import com.jeonse.dto.CommonchecklistDTO;
import com.jeonse.dto.IbkansimjeonseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IbkansimjeonseService {

    int insertIbkansimjeonse(IbkansimjeonseDTO ibkansimjeonseDTO);

    IbkansimjeonseDTO getIbkansimjeonseDTO(int wishlistNum);
    int deleteIbkAnsimjeonse(int wishlistNum);
}
