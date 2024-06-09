package com.peterolah.example.email;

public class SimpleEmailSender {
    //private final EmailSenderConfig config;
    private final MailSender emailSender;
    //private final ObjectMapper objectMapper;

    public void send() {
//        final String text = toText(daten);
//        final String subject = "WM-Daten-Änderung: " + daten.getIsin() + "-" + daten.getBezugsId();
//        log.trace("Sende Email mit Subject {} an {} mit Inhalt {}", subject, config.getTo(), text);
//        config.getTo().forEach(to -> {
//            final var message = new SimpleMailMessage();
//            message.setFrom(config.getFrom());
//            message.setTo(to);
//            message.setSubject(subject);
//            message.setText(text);
//            try {
//                log.debug("Sende Email an {} für {} und {}", to,
//                        keyValue(Arguments.ISIN, daten.getIsin()),
//                        keyValue(Arguments.BEZUGSID, daten.getBezugsId()));
//                emailSender.send(message);
//            } catch (MailException e) {
//                log.error("Fehler beim senden der Email an {} für {} und {}", to,
//                        keyValue(Arguments.ISIN, daten.getIsin()),
//                        keyValue(Arguments.BEZUGSID, daten.getBezugsId()), e);
//            }
//        });

        final var message = new SimpleMailMessage();
            message.setFrom(config.getFrom());
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
    }


}
