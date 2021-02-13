package com.nexters.giftzip.interfaces.common.entity.admin;

import com.nexters.giftzip.interfaces.admin.request.NoticeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public void setAdmin(NoticeRequest request) {
        AdminDocument adminDocument = new AdminDocument();
        adminDocument.setTitle(request.getTitle());
        adminDocument.setContent(request.getContent());
        adminRepository.save(adminDocument);
    }

    public List<AdminDocument> getAdminList() {
        return adminRepository.findAllByOrderByCreatedAtDesc();
    }

}
