package com.mackenzie.cif.information.source.domain.dto;

import com.mackenzie.cif.information.source.domain.InformationSource;
import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class InformationSourceDTO {
    private Integer id;
    private String description;

    public static InformationSourceDTO create(InformationSource i){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, InformationSourceDTO.class);
    }
}
