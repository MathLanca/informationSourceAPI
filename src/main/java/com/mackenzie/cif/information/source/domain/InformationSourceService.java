package com.mackenzie.cif.information.source.domain;

import com.mackenzie.cif.information.source.domain.dto.InformationSourceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InformationSourceService {

    @Autowired
    private InformationSourceRepository repository;

    public List<InformationSourceDTO> listAll(){
        log.info("List all information source on data base");
        return repository.findAll()
            .stream()
            .map(InformationSourceDTO::create).collect(Collectors.toList());
    }

    public InformationSourceDTO findById(Integer id){
        log.info("Find information source by ID");
        Optional<InformationSource> optional = repository.findById(id);
        if(optional == null)
            return null;
        InformationSourceDTO informationSourceDTO = InformationSourceDTO.create(optional.get());
        return informationSourceDTO;
    }
}
