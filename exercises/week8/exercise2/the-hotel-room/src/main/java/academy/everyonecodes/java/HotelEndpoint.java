package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {
    private String messageAll;
    private String messagePrivate;

    public HotelEndpoint(@Value("${hotel.message.all}") String messageAll, @Value("${hotel.message.private}") String messagePrivate) {
        this.messageAll = messageAll;
        this.messagePrivate = messagePrivate;
    }

    @GetMapping
    public String get() {
        return messageAll;
    }

    @GetMapping("room")
    public String getPrivate() {
        return messagePrivate;
    }
}
