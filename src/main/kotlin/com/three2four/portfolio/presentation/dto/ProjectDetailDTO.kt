package com.three2four.portfolio.presentation.dto

import com.three2four.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDTO (
    val content:String,
    val url: String?
){
    constructor(projectDetail: ProjectDetail) : this(
        content = projectDetail.content,
        url = projectDetail.url
    )
}