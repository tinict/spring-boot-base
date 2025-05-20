package com.bvtw.domain.dto.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerUpdateRequest {
    private String partnerName;
    private String partnerDisplayBrandName;
    private String partnerType;
    private String partnerStatus;
    private String partnerDescription;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
