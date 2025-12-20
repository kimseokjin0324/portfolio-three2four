package com.three2four.portfolio.admin.context.project.controller

import com.three2four.portfolio.admin.context.project.service.AdminProjectSkillService
import com.three2four.portfolio.admin.data.FormElementDTO
import com.three2four.portfolio.admin.data.SelectFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/project/skill")
class AdminProjectSkillViewController (
        private val adminProjectSkillService: AdminProjectSkillService
){

    @GetMapping
    fun projectSkill(model: Model): String {

        val projectList = adminProjectSkillService.getProjectList()
        val skillList = adminProjectSkillService.getSkillList()

        val formElements = listOf<FormElementDTO>(
                SelectFormElementDTO("project",8,projectList),
                SelectFormElementDTO("skill",4,skillList)
        )
        model.addAttribute("formElements", formElements)
        val table = adminProjectSkillService.getProjectSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes= mutableMapOf<String,Any>(
                Pair("menuName","Projects"),
                Pair("pageName",table.name),
                //화면단에 공통적으로 수정,삭제, hasDetails 여부로 각 페이지 화면에 컨트롤 할 수 있도록 넣어두는것
                Pair("editable",false),
                Pair("deletable",true),
                Pair("hasDetails",false),
        )

        model.addAttribute("pageAttributes", pageAttributes)
        return "admin/page-table"
    }
}