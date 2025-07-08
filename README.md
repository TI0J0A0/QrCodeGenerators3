# QrCodeGenerators3 🌐

A simple and robust QR Code generator built with Java (Spring Boot), AWS S3 integration, and Docker support.

---

## 🚀 Features

- Dynamically generates QR codes from text or URLs.
- Automatically uploads generated QR codes to an AWS S3 bucket.
- RESTful API endpoints:
  - `POST /api/qrcode` – generate and upload a QR code.
  - `GET /api/qrcode/{key}` – retrieve the public URL of a stored QR code.
- Configurable via `application.properties` and environment variables.

---

## 🛠️ Tech Stack

| Technology     | Role                       |
|----------------|----------------------------|
| Java 17+       | Backend development        |
| Spring Boot    | Web framework & DI         |
| ZXing          | QR code generation         |
| AWS SDK v2     | Integration with AWS S3    |
| Docker         | Containerization           |
| Maven          | Build tool & dependency management |

---

## 🔧 Requirements

- Java 17 or higher
- Docker (optional, for containerization)
- AWS account with:
  - S3 bucket created
  - Access key and secret key

Example environment variables:

```bash
export AWS_ACCESS_KEY_ID=...
export AWS_SECRET_ACCESS_KEY=...
export AWS_BUCKET_NAME=my-bucket
export AWS_REGION=sa-east-1
