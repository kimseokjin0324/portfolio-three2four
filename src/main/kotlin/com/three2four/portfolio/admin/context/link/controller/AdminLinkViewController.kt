package com.three2four.portfolio.admin.context.link.controller

import com.three2four.portfolio.admin.context.link.service.AdminLinkService
import com.three2four.portfolio.admin.data.DateFormElementDTO
import com.three2four.portfolio.admin.data.FormElementDTO
import com.three2four.portfolio.admin.data.SelectFormElementDTO
import com.three2four.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/link")
class AdminLinkViewController(
        private val linkService: AdminLinkService
) {
    fun link(model: Model): String {
        val formElements = listOf<FormElementDTO>(
                TextFormElementDTO("name",2),
                TextFormElementDTO("content", 8),
                SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),

                )

        model.addAttribute("formElements", formElements)

        val table = linkService.getLinkTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes= mutableMapOf<String,Any>(
                Pair("menuName","Index"),
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