package com.db.design_patterns.never_use_switch.mail_strategy;

import com.db.design_patterns.never_use_switch.MailInfo;
import org.springframework.stereotype.Component;

@Component
public class CallUsMail implements MailTemplateCreator {

    public String getMailTemplate(MailInfo mailInfo){
        return "Don t call us, we ll call you. Sending to " + mailInfo.getClientEmail();
    }

    @Override
    public String getMailCode() {
        return "2";
    }
}
