package Practice.Controller;

import Practice.hibernate.HibernateInternalsService;
import Practice.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hibernate")
public class HibernateInternalsController {

    private final HibernateInternalsService hibernateInternalsService;

    public HibernateInternalsController(HibernateInternalsService hibernateInternalsService) {
        this.hibernateInternalsService = hibernateInternalsService;
    }

    @GetMapping("/persistence-context/{email}")
    public Map<String, Object> inspectPersistenceContext(@PathVariable String email) {
        return hibernateInternalsService.inspectPersistenceContext(email);
    }

    @PutMapping("/dirty-checking/{email}")
    public Users updateWithDirtyChecking(@PathVariable String email, @RequestParam String name) {
        return hibernateInternalsService.updateWithDirtyChecking(email, name);
    }

    @PutMapping("/flush/{email}")
    public Users updateAndFlush(@PathVariable String email, @RequestParam String name) {
        return hibernateInternalsService.updateAndFlush(email, name);
    }

    @GetMapping("/entity-states/{email}")
    public Map<String, String> inspectEntityStates(@PathVariable String email) {
        return hibernateInternalsService.inspectEntityStates(email);
    }

    @GetMapping("/clear/{email}")
    public Map<String, Object> clearPersistenceContext(@PathVariable String email) {
        return hibernateInternalsService.clearPersistenceContext(email);
    }
}
