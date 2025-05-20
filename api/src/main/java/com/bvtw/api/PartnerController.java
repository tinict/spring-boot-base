package com.bvtw.api;

import com.bvtw.domain.dto.identifier.PartnerCreateRequest;
import com.bvtw.domain.entity.Partner;
import com.bvtw.service.identifier.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partners")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<?> createPartner(@RequestBody PartnerCreateRequest partnerCreateRequest) {
        Partner partnerRequest = partnerCreateRequest.partnerToEntity();
        Partner registerPartner = partnerService.save(partnerRequest);

        return ResponseEntity.ok(registerPartner);
    }

    @GetMapping("/hello")
    public String hello() {
        // Get the access token from the OAuth2AuthorizedClient
//        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        return "Hello, test. Access Token: ";
    }
}
