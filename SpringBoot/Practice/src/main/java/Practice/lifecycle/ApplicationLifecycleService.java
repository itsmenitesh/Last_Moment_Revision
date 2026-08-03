package Practice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ApplicationLifecycleService {

    private static final Logger log = LoggerFactory.getLogger(ApplicationLifecycleService.class);

    private final Clock applicationClock;
    private ExecutorService auditExecutor;
    private Instant startedAt;
    private boolean running;

    public ApplicationLifecycleService(Clock applicationClock) {
        this.applicationClock = applicationClock;
    }

    @PostConstruct
    public void start() {
        auditExecutor = Executors.newSingleThreadExecutor();
        startedAt = applicationClock.instant();
        running = true;
        log.info("Application lifecycle service started at {}", startedAt);
    }

    public Map<String, Object> getStatus() {
        return Map.of(
                "running", running,
                "startedAt", startedAt,
                "auditWorkerShutdown", auditExecutor.isShutdown()
        );
    }

    public void recordAuditEvent(String event) {
        if (running) {
            auditExecutor.submit(() -> log.info("Audit event: {}", event));
        }
    }

    @PreDestroy
    public void stop() {
        running = false;
        auditExecutor.shutdown();
        try {
            if (!auditExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                auditExecutor.shutdownNow();
            }
        } catch (InterruptedException exception) {
            auditExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Application lifecycle service stopped");
    }
}
