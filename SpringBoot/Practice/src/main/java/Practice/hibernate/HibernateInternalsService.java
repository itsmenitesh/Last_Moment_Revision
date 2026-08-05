package Practice.hibernate;

import Practice.UsersRepository.UsersRepository;
import Practice.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class HibernateInternalsService {

    private final EntityManager entityManager;
    private final UsersRepository usersRepository;

    public HibernateInternalsService(EntityManager entityManager, UsersRepository usersRepository) {
        this.entityManager = entityManager;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public Map<String, Object> inspectPersistenceContext(String email) {
        Users firstLoad = findUser(email);
        Users secondLoad = findUser(email);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("firstLoadManaged", entityManager.contains(firstLoad));
        result.put("secondLoadManaged", entityManager.contains(secondLoad));
        result.put("sameJavaObject", firstLoad == secondLoad);
        result.put("explanation", "Both repository calls returned the same managed entity from the persistence context");
        return result;
    }

    @Transactional
    public Users updateWithDirtyChecking(String email, String name) {
        Users user = findUser(email);
        user.setName(name);
        return user;
    }

    @Transactional
    public Users updateAndFlush(String email, String name) {
        Users user = findUser(email);
        user.setName(name);
        entityManager.flush();
        return user;
    }

    @Transactional
    public Map<String, String> inspectEntityStates(String email) {
        Users newUser = new Users();
        Users managedUser = findUser(email);
        entityManager.detach(managedUser);
        Users mergedUser = entityManager.merge(managedUser);

        Map<String, String> result = new LinkedHashMap<>();
        result.put("newUser", entityManager.contains(newUser) ? "MANAGED" : "TRANSIENT");
        result.put("loadedUser", "MANAGED when loaded from the repository");
        result.put("afterDetach", entityManager.contains(managedUser) ? "MANAGED" : "DETACHED");
        result.put("mergeResult", entityManager.contains(mergedUser) ? "MANAGED" : "DETACHED");
        result.put("removed", "An entity becomes REMOVED after entityManager.remove(entity)");
        return result;
    }

    @Transactional
    public Map<String, Object> clearPersistenceContext(String email) {
        Users loadedUser = findUser(email);
        boolean managedBeforeClear = entityManager.contains(loadedUser);

        entityManager.clear();

        Users reloadedUser = findUser(email);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("managedBeforeClear", managedBeforeClear);
        result.put("managedAfterClear", entityManager.contains(loadedUser));
        result.put("reloadedManaged", entityManager.contains(reloadedUser));
        result.put("sameJavaObjectAfterClear", loadedUser == reloadedUser);
        result.put("explanation", "clear detached every managed entity, so Hibernate loaded a new object");
        return result;
    }

    private Users findUser(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + email));
    }
}
