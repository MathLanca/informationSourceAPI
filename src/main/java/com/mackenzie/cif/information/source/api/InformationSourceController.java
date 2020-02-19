package com.mackenzie.cif.information.source.api;

import com.mackenzie.cif.information.source.domain.InformationSourceService;
import com.mackenzie.cif.information.source.domain.dto.InformationSourceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1")
@Slf4j
public class InformationSourceController {
    @Autowired
    private InformationSourceService service;

    @GetMapping("/listAll")
    public List<InformationSourceDTO> listAll(){
        log.info("List all information service started >>>>");
        return service.listAll();
    }

    @GetMapping("/information/{id}")
    public ResponseEntity<InformationSourceDTO> findById(@PathVariable @NotNull Integer id){
        log.info("Find information by ID service started >>>>");
        InformationSourceDTO resposne = null;
        try{
            resposne = service.findById(id);
        }catch (NoSuchElementException e){
            return new ResponseEntity("Could not find element with ID: "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(resposne, HttpStatus.OK);
    }
}
