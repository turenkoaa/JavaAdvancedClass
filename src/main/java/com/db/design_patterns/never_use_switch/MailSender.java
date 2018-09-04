package com.db.design_patterns.never_use_switch;

import com.db.design_patterns.never_use_switch.dao.MailDAO;
import com.db.design_patterns.never_use_switch.mail_strategy.MailTemplateCreator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Component
public class MailSender {

    @Autowired
    private MailDAO mailDAO;

    @Autowired
    private Map<String, MailTemplateCreator> creatorsMap;

    public MailSender() {}

    //todo 2 codes for one creator
    @Autowired
    public void setCreatorsMap(Set<MailTemplateCreator> creators){
        creatorsMap = creators.stream()
                .collect(toMap(MailTemplateCreator::getMailCode, Function.identity(),
                        (v1, v2) -> {
                            throw new IllegalStateException("Double mail code for different strategies");
                        })
                );
    }

    @Scheduled(cron = "*/1 * * * * *")
    public void sendMail() {
        MailInfo mailInfo = mailDAO.getMailInfo();
        String mailCode = String.valueOf(mailInfo.getMailCode());
        if (creatorsMap.containsKey(mailCode)) {
            MailTemplateCreator templateCreator = creatorsMap.get(mailCode);
            String mailTemplate = templateCreator.getMailTemplate(mailDAO.getMailInfo());
            System.out.println("Mail code = " + mailCode + " " + mailTemplate);
        } else {
            throw new IllegalStateException("Mail code = " + mailCode + " is not supported");
        }
    }

}
