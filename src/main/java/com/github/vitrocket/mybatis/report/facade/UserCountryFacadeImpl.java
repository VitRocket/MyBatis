package com.github.vitrocket.mybatis.report.facade;

import com.github.vitrocket.mybatis.entity.Session;
import com.github.vitrocket.mybatis.mail.EmailMessage;
import com.github.vitrocket.mybatis.mail.EmailService;
import com.github.vitrocket.mybatis.report.directory.DocumentType;
import com.github.vitrocket.mybatis.report.pojo.UserCountryDTO;
import com.github.vitrocket.mybatis.report.service.UserCountryReport;
import com.github.vitrocket.mybatis.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vit Rocket on 18.11.2017.
 * @version 1.0
 * @since on 18.11.2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserCountryFacadeImpl implements UserCountryFacade {

    private final SessionService sessionService;
    private final UserCountryReport userCountryReport;
    private final EmailService emailService;

    @Override
    public void makeDocument(String email, DocumentType documentType, LocalDate localDate) {
        List<Session> sessions = sessionService.getSessionUserGroupCountry(localDate);
        List<UserCountryDTO> userCountryDTOs = sessions.stream().map(UserCountryDTO::fromModel).collect(Collectors.toList());
        Collections.sort(userCountryDTOs, ((o1, o2) -> o1.getCountryName().compareTo(o2.getCountryName())));

        String file = userCountryReport.createReport(documentType, userCountryDTOs, localDate);
        log.info(file);

        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(email);
        emailMessage.setSubject("Report " + documentType + localDate);
        emailMessage.setContent("Report " + documentType + localDate);
        emailMessage.setFrom("example@example.com");
        emailMessage.setAttachment(file);

        try {
            emailService.sendEmail(emailMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}
