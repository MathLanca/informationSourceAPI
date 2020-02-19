package com.mackenzie.cif.information.source.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationSourceRepository extends JpaRepository<InformationSource, Integer> {}
