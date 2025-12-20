package com.three2four.portfolio.admin.context.link.service

import com.three2four.portfolio.admin.data.TableDTO
import com.three2four.portfolio.domain.entity.Link
import com.three2four.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService (
        private val linkRepository: LinkRepository
){
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}