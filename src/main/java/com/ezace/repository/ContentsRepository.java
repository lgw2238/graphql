package com.ezace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezace.domain.Contents;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
	Contents findByIdx(int idx);
}