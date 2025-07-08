package aguiar.projects.qrgenerators3.service;

import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.ByteArrayOutputStream;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text, int width, int height) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
        return outputStream.toByteArray();
      }
    
}
