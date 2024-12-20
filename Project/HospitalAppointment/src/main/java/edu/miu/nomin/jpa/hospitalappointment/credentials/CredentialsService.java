package edu.miu.nomin.jpa.hospitalappointment.credentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService {
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CredentialsModel register(CredentialsModel credentialsModel) {
//        String encodedPassword = passwordEncoder.encode(credentialsModel.getPassword());
//        credentialsModel.setPassword(encodedPassword);
//        return credentialsRepository.save(credentialsModel);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        credentialsModel.setPassword(bCryptPasswordEncoder.encode(credentialsModel.getPassword()));
        return credentialsRepository.save(credentialsModel);
    }

}
