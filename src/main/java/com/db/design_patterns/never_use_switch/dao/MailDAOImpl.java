package com.db.design_patterns.never_use_switch.dao;

import com.db.design_patterns.never_use_switch.MailInfo;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MailDAOImpl implements MailDAO {

    private DataFactory dataFactory = new DataFactory();

    @Override
    public MailInfo getMailInfo() {
        return MailInfo.builder()
                .clientName(dataFactory.getName())
                .clientEmail(dataFactory.getEmailAddress())
                .mailCode(dataFactory.getNumberBetween(1, 7))
                .build();
    }
}
