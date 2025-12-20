package com.three2four.portfolio.admin.context.skill.controller

import com.three2four.portfolio.admin.context.skill.service.AdminSkillService
import com.three2four.portfolio.admin.data.FormElementDTO
import com.three2four.portfolio.admin.data.SelectFormElementDTO
import com.three2four.portfolio.admin.data.TextFormElementDTO
import com.three2four.portfolio.domain.constrant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(
        private val adminSkillService: AdminSkillService
) {
    fun skill(model: Model): String {
        val formElements = listOf<FormElementDTO>(
                TextFormElementDTO("name",2),
                SelectFormElementDTO("type", 2,SkillType.values().map { it.name }),
                SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),

                )

        model.addAttribute("formElements", formElements)

        val table = adminSkillService.getSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes= mutableMapOf<String,Any>(
                Pair("menuName","Resume"),
                Pair("pageName",table.name),
                //화면단에 공통적으로 수정,삭제, hasDetails 여부로 각 페이지 화면에 컨트롤 할 수 있도록 넣어두는것
                Pair("editable",true),
                Pair("deletable",false),
                Pair("hasDetails",false),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}