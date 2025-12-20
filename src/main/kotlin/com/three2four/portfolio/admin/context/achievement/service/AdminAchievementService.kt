package com.three2four.portfolio.admin.context.achievement.service

import com.three2four.portfolio.admin.data.TableDTO
import com.three2four.portfolio.domain.entity.Achievement
import com.three2four.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
        private val achievementRepository: AchievementRepository
) {
    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}