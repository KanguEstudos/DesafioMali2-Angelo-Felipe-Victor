package br.com.kangu.muser.services;

import br.com.kangu.muser.entities.User;
import br.com.kangu.muser.repositories.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"br.com.kangu.muser.services"})
public class UserService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    UserRepository userRepository;

    public User saveAndNotify(User user) throws jakarta.mail.MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(user.getEmail());
        helper.setSubject(user.getName() + ", Bem vindo(a) a Kangu.");
        helper.setText("<strong><span style=\"color: #FF4500;\">Confira os seus dados de acesso:</span></strong><br>" +
                       "<span style=\"color: #808080;\">Email: " + user.getEmail() + "</span><br><span style=\"color: #808080;\">Usuário: " + user.getName() + "</span>", true);
        emailSender.send(message);

        return userRepository.save(user);
    }
}
