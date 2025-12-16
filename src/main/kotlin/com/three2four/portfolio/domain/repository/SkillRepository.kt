package com.three2four.portfolio.domain.repository

import com.three2four.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository:JpaRepository<Skill, Long> {

}