package com.three2four.portfolio.admin.context.skill.service

import com.three2four.portfolio.admin.data.TableDTO
import com.three2four.portfolio.domain.entity.Skill
import com.three2four.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService (
        private val skillRepository: SkillRepository
){
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}