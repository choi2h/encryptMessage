package encrypt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class EncryptService {
    private static final Logger logger = LoggerFactory.getLogger(EncryptService.class);

    private static final String ALGORITHM = "SHA-256";

    public String getEncryptMessage(String message){
        logger.info("Receive request for encrypt message. message={}", message);

        String hashPassword;
        try {
            hashPassword = hashingMessage(message);
        } catch (Exception e){
            logger.error("Failed to encrypt the message. message={}", message, e);
            return null;
        }

        return hashPassword;
    }

    private String hashingMessage(String message) throws Exception {
        byte[] hashMessage=null;
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);

        for(int i = 0; i < 10000; i++) {
            messageDigest.update(message.getBytes());
            hashMessage = messageDigest.digest();
        }

        return Byte_to_String(hashMessage);
    }

    private String Byte_to_String(byte[] temp) {
        StringBuilder sb = new StringBuilder();
        for(byte a : temp) {
            sb.append(String.format("%02x", a));
        }
        return sb.toString();
    }
}
