package aguiar.projects.qrgenerators3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import aguiar.projects.qrgenerators3.service.QRCodeService;
import aguiar.projects.qrgenerators3.service.S3Service;

@RestController
@RequestMapping("/api/qrcode")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeService qrCodeService;
    private final S3Service s3Service;

    @PostMapping
    public String generateAndUpload(@RequestParam String text) throws Exception {
        byte[] qr = qrCodeService.generateQRCode(text, 300, 300);
        return s3Service.uploadToS3(qr);
    }
}
// Note: Ensure that the AWS credentials are set in the environment variables