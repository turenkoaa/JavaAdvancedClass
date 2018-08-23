package com.db.design_patterns.never_use_switch.dao;

import com.db.design_patterns.never_use_switch.MailInfo;
import org.fluttercode.datafactory.impl.DataFactory;

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
