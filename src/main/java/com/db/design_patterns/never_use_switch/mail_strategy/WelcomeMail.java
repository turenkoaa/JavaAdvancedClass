package com.db.design_patterns.never_use_switch.mail_strategy;

import com.db.design_patterns.never_use_switch.MailInfo;

@MailCode(6)
@MailCode(1)
public class WelcomeMail implements MailTemplateCreator {

    public String getMailTemplate(MailInfo mailInfo){
        return "Welcome " + mailInfo.getClientName() + ". Sending to " + mailInfo.getClientEmail();
    }
}
