package com.db.design_patterns.never_use_switch.mail_strategy;

import com.db.design_patterns.never_use_switch.MailInfo;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMail implements MailTemplateCreator {

    public String getMailTemplate(MailInfo mailInfo){
        return "Welcome " + mailInfo.getClientName() + ". Sending to " + mailInfo.getClientEmail();
    }

    @Override
    public String getMailCode() {
        return "6";
    }
}
