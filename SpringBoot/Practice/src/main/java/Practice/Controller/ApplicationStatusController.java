package Practice.Controller;

import Practice.lifecycle.ApplicationLifecycleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/application")
public class ApplicationStatusController {

    private final ApplicationLifecycleService applicationLifecycleService;

    public ApplicationStatusController(ApplicationLifecycleService applicationLifecycleService) {
        this.applicationLifecycleService = applicationLifecycleService;
    }

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return applicationLifecycleService.getStatus();
    }
}
