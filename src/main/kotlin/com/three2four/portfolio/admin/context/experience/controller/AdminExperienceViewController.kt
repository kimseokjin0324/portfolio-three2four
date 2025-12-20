package com.three2four.portfolio.admin.context.experience.controller


import com.three2four.portfolio.admin.context.experience.service.AdminExperienceService
import com.three2four.portfolio.admin.data.FormElementDTO
import com.three2four.portfolio.admin.data.SelectFormElementDTO
import com.three2four.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/experience")
class AdminExperienceViewController(
        val adminExperienceService: AdminExperienceService
) {

    @GetMapping
    fun experience(model: Model): String {
        val formElement = listOf<FormElementDTO>(
                TextFormElementDTO("title",4),
                TextFormElementDTO("description",8),
                SelectFormElementDTO("startYear",3,(2010..2030).toList()),
                SelectFormElementDTO("startMonth",2,(1..12).toList()),
                SelectFormElementDTO("endYear",3,(2010..2030).toList()),
                SelectFormElementDTO("endMonth",2,(1..12).toList()),
                SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElement",formElement)

        val detailFormElements = listOf<FormElementDTO>(
                TextFormElementDTO("content",10),
                SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("detailFormElements",detailFormElements)

        val table = adminExperienceService.getExperienceTable()
        model.addAttribute("table", table)

        val detailTable = adminExperienceService.getExperienceDetailTable(null)
        model.addAttribute("detailTable", detailTable)

        val pageAttributes= mutableMapOf<String,Any>(
                Pair("menuName","Resume"),
                Pair("pageName",table.name),
                //화면단에 공통적으로 수정,삭제, hasDetails 여부로 각 페이지 화면에 컨트롤 할 수 있도록 넣어두는것
                Pair("editable",true),
                Pair("deletable",false),
                Pair("hasDetails",true),
        )

        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}