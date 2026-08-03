package Practice.files;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.UUID;

@Service
public class FileStorageService {

    private static final Set<String> ALLOWED_CONTENT_TYPES = Set.of("application/pdf", "image/jpeg", "image/png", "image/gif", "image/webp");

    private final Path storageDirectory;

    public FileStorageService(@Value("${app.storage.upload-dir:uploads}") String uploadDirectory) {
        this.storageDirectory = Path.of(uploadDirectory).toAbsolutePath().normalize();
    }

    @PostConstruct
    public void initializeStorage() {
        try {
            Files.createDirectories(storageDirectory);
        } catch (IOException exception) {
            throw new IllegalStateException("Could not create upload directory", exception);
        }
    }

    public StoredFile store(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is required");
        }

        String contentType = file.getContentType();
        if (contentType == null || !ALLOWED_CONTENT_TYPES.contains(contentType)) {
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Only PDF and image files are allowed");
        }

        String fileName = UUID.randomUUID() + extensionFor(contentType);
        Path target = storageDirectory.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            return new StoredFile(fileName, contentType, file.getSize());
        } catch (IOException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not store file", exception);
        }
    }

    public Resource load(String fileName) {
        Path file = storageDirectory.resolve(fileName).normalize();
        if (!file.getParent().equals(storageDirectory) || !Files.isRegularFile(file)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        }

        try {
            return new UrlResource(file.toUri());
        } catch (MalformedURLException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not read file", exception);
        }
    }

    private String extensionFor(String contentType) {
        return switch (contentType) {
            case "application/pdf" -> ".pdf";
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "image/gif" -> ".gif";
            case "image/webp" -> ".webp";
            default -> throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Unsupported file type");
        };
    }
}
