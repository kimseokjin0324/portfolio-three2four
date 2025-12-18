package com.three2four.portfolio.presentation.dto

import com.three2four.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content:String,
){
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}