package com.bvtw.domain.dto.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerResponse {
    private String id;
    private String partnerCode;
    private String partnerName;
    private String partnerDisplayBrandName;
    private String partnerType;
    private String partnerStatus;
    private String partnerDescription;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String createdAt;
    private String updatedAt;
}
