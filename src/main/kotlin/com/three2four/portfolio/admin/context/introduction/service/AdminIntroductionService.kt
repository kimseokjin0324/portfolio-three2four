package com.three2four.portfolio.admin.context.introduction.service

import com.three2four.portfolio.admin.data.TableDTO
import com.three2four.portfolio.domain.entity.Introduction
import com.three2four.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService (
        private val introductionRepository: IntroductionRepository
){
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}