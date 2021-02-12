package com.nexters.giftzip.interfaces.admin;

import com.nexters.giftzip.interfaces.common.entity.admin.AdminDocument;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/list")
    public String findAll(ModelAndView model) {
        List<AdminDocument> adminList = adminService.getAdminList();
        model.addObject("adminList", adminList);
        return "/admin";
    }
}
