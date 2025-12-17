package com.three2four.portfolio.domain.repository

import com.three2four.portfolio.domain.entity.Introduction
import com.three2four.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Link>
}