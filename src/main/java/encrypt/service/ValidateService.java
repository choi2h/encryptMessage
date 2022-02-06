package encrypt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidateService {
    private final static Logger logger = LoggerFactory.getLogger(ValidateService.class);

    public boolean isValidationMessage(String message){
        if(message != null && message.length() > 0){
            return true;
        }

        logger.info("Receive empty message. message={}", message);

        return false;
    }
}
