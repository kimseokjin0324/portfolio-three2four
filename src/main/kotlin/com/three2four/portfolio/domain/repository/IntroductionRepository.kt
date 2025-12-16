package com.three2four.portfolio.domain.repository

import com.three2four.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {

    fun findByAllByIsActive(isActive: Boolean): List<Introduction>
}