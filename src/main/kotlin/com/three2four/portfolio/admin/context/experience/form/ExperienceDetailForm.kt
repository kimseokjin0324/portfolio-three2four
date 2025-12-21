package com.three2four.portfolio.admin.context.experience.form

import com.three2four.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

data class ExperienceDetailForm(
        val id: Long,

        @field:NotBlank(message="필수 값입니다.")
        val content :String,

        val isActive:Boolean
){

    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
                content = this.content,
                isActive = this.isActive
        )
    }
}