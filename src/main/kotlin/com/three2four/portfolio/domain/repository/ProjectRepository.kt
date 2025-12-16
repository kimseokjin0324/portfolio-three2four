package com.three2four.portfolio.domain.repository

import com.three2four.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository:JpaRepository<Project, Long> {

}