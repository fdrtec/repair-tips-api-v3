package com.fdrtec.api.repair.tips.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdrtec.api.repair.tips.domain.model.entity.Type;

public interface TypeRepository extends JpaRepository<Type, UUID> {

}
