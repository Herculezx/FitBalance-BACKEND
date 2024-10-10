package br.itb.projeto.fitBalance.service;
 
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
 
@Service
public class EmailService {
    public void enviarEmail(
      String email, String assunto, String conteudo
    ) {

       
        var sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername(Environment.getProperties().getProperty("spring.mail.username"));
        sender.setPassword(Environment.getProperties().getProperty("spring.mail.password"));
       
        Properties mailProperties = new Properties();  
        mailProperties.put("mail.smtp.host", "smtp.gmail.com");  
        mailProperties.put("mail.smtp.auth", "true");  
        mailProperties.put("mail.smtp.port", "465");  
        mailProperties.put("mail.smtp.starttls.enable", "true");  
        mailProperties.put("mail.smtp.socketFactory.port", "465");  
        mailProperties.put("mail.smtp.socketFactory.fallback", "false");  
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        var mensagem = new SimpleMailMessage();
        mensagem.setFrom(Environment.getProperties().getProperty("spring.mail.username"));
        mensagem.setTo(email);
        mensagem.setSubject(assunto);
        mensagem.setText(conteudo);
        
        sender.send( mensagem);
    }
}