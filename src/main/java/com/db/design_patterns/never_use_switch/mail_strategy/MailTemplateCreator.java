package com.db.design_patterns.never_use_switch.mail_strategy;

import com.db.design_patterns.never_use_switch.MailInfo;

public interface MailTemplateCreator {
    String getMailTemplate(MailInfo mailInfo);
    String getMailCode();
}
