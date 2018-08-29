package com.db.design_patterns.never_use_switch;

import com.db.design_patterns.never_use_switch.dao.MailDAO;
import com.db.design_patterns.never_use_switch.dao.MailDAOImpl;
import com.db.design_patterns.never_use_switch.mail_strategy.MailCode;
import com.db.design_patterns.never_use_switch.mail_strategy.MailTemplateCreator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

public class MailSender {

    private MailDAO mailDAO = new MailDAOImpl();
    private Map<Integer, MailTemplateCreator> mailStrategies = new HashMap<>();

    public MailSender() {
        init();
    }

    @SneakyThrows
    private void init() {
        Reflections scanner = new Reflections("com.db.design_patterns.never_use_switch");
        Set<Class<? extends MailTemplateCreator>> classes = scanner.getSubTypesOf(MailTemplateCreator.class);
        for (Class<? extends MailTemplateCreator> clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                MailCode[] annotations = clazz.getAnnotationsByType(MailCode.class);
                if (annotations.length == 0) {
                    throw new IllegalStateException("No annotation specified for class");
                }
                for (MailCode annotation : annotations) {
                    mailStrategies.merge(
                            annotation.value(),
                            clazz.newInstance(),
                            (v1, v2) -> {throw new IllegalStateException("Double mail code for different strategies");}
                    );
                }
            }
        }
    }

    public void sendMail() {
        MailInfo mailInfo = mailDAO.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        if (mailStrategies.containsKey(mailCode)) {
            MailTemplateCreator templateCreator = mailStrategies.get(mailCode);
            String mailTemplate = templateCreator.getMailTemplate(mailDAO.getMailInfo());
            System.out.println("Mail code = " + mailCode + " " + mailTemplate);
        } else {
            throw new IllegalStateException("Mail code = " + mailCode + " is not supported");
        }
    }

}
