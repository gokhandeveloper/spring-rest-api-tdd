package routes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.MessageRequest;
import response.MessageResponse;
import usecase.GetMessage;

@Log4j2(topic = "controller")
@RestController
@RequiredArgsConstructor
public class Routes {
    private final GetMessage getMessageService;

    @GetMapping("/message/{id}")
    private ResponseEntity<MessageResponse> hello(@PathVariable Long id) throws Exception {
        log.info(String.format("GET request with message id: %s", id));
            return new ResponseEntity<>(getMessageService.getMessage(id), HttpStatus.OK);
        }

    @PostMapping("/message")
    private ResponseEntity<MessageResponse> hello(@RequestBody MessageRequest request) throws Exception {
        log.info(String.format("POST request with message: %s and" + "delivery time %s",
                request.getMessage().getContent(), request.getMessage().getDeliveryTime()));
            return new ResponseEntity<>(getMessageService.postMessage(request.getMessage()), HttpStatus.ACCEPTED);
        }
}

