package encrypt.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EncryptServiceTest {

    @Autowired
    EncryptService encryptService;

    @Test
    void encryptMessageTest(){
        String encryptMessage = encryptService.getEncryptMessage("TestEncryptMessage");

        assertNotNull(encryptMessage);
    }
}