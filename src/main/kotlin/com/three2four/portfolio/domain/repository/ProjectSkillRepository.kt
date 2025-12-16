package com.three2four.portfolio.domain.repository

import com.three2four.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
    fun findByProjectIdAndSkill(projectId: Long, skillId: Long): Optional<ProjectSkill>
}