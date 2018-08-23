package com.db.design_patterns.never_use_switch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailInfo {
    private String clientName;
    private String clientEmail;
    private int mailCode;

}
