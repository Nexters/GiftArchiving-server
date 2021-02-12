package com.nexters.giftzip.interfaces.admin;

import com.nexters.giftzip.interfaces.common.entity.admin.AdminDocument;
import com.nexters.giftzip.interfaces.common.entity.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public void setAdmin(String title, String content) {

    }

    public List<AdminDocument> getAdminList() {
        return adminRepository.findAllByOrderByCreatedAtDesc();
    }

}
