package com.nexters.giftzip.interfaces.admin;

import com.nexters.giftzip.interfaces.admin.request.NoticeRequest;
import com.nexters.giftzip.interfaces.common.entity.admin.AdminDocument;
import io.swagger.models.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/list")
    public ModelAndView findAll(ModelAndView model) {
        List<AdminDocument> adminList = adminService.getAdminList();
        model.addObject("adminList", adminList);
        model.setViewName("/admin");
        return model;
    }

    @GetMapping
    public String createNotice() {
        return "/admin_write";
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createNotice(@ModelAttribute NoticeRequest request) {
        adminService.setAdmin(request);
        return "redirect:admin/list";
    }
}
