package encrypt.controller;

import encrypt.model.ResponseMessage;
import encrypt.service.EncryptService;
import encrypt.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EncryptController {

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private ValidateService validateService;

    @GetMapping
    public ResponseEntity<String> getEncryptMessage(@PathVariable("message") String message){

        if(validateService.isValidationMessage(message)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessage.BAD_REQUEST_EMPTY_MESSAGE);
        }

        String encryptMessage = encryptService.getEncryptMessage(message);

        if(encryptMessage == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseMessage.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(encryptMessage);
    }
}
