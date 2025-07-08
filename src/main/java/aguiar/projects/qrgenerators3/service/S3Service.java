package aguiar.projects.qrgenerators3.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import jakarta.annotation.PostConstruct;

import java.util.UUID;

@Service
public class S3Service{ 

    @Value("${aws.s3.bucket}")
    private String bucket;

    private S3Client s3;

    @PostConstruct
    public void init() {
        s3 = S3Client.builder()
            .region(Region.US_EAST_1) // ajuste se estiver em outra região
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .build();
    }

    public String uploadToS3(byte[] imageBytes) {
        String key = "qrcodes/" + UUID.randomUUID() + ".png";

        s3.putObject(PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(key)
                        .contentType("image/png")
                        .build(),
                RequestBody.fromBytes(imageBytes));

        return "https://" + bucket + ".s3.amazonaws.com/" + key;
    }
}
// Note: Ensure that the AWS credentials are set in the environment variables