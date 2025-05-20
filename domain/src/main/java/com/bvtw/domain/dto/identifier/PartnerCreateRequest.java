package com.bvtw.domain.dto.identifier;

import com.bvtw.domain.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerCreateRequest {
    private String partnerCode;
    private String partnerName;
    private String partnerDisplayBrandName;
    private String partnerType;
    private String partnerStatus;
    private String partnerDescription;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

    public Partner partnerToEntity() {
        return new Partner()
                .setPartnerCode(partnerCode)
                .setPartnerName(partnerName)
                .setPartnerDisplayBrandName(partnerDisplayBrandName)
                .setPartnerType(partnerType)
                .setPartnerStatus(partnerStatus)
                .setPartnerDescription(partnerDescription)
                .setContactName(contactName)
                .setContactEmail(contactEmail)
                .setContactPhone(contactPhone);
    }
}
