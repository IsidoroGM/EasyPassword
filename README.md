# 🔐 EasyPassword API

### Generador de contraseñas seguras con Spring Boot + Seguridad integrada

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)
![Security](https://img.shields.io/badge/Security-BasicAuth-red)
![Status](https://img.shields.io/badge/status-in%20progress-yellow)

---

## 🚀 Sobre el proyecto

**EasyPassword API** es una aplicación backend desarrollada en Java con Spring Boot que permite generar contraseñas seguras de forma configurable y protegida mediante autenticación.

Este proyecto simula un entorno real de desarrollo backend, aplicando buenas prácticas de:

* Arquitectura por capas
* Seguridad en APIs
* Validación de datos
* Generación criptográfica

---

## ✨ Features principales

✔ Generación de contraseñas seguras con `SecureRandom`
✔ Configuración dinámica de longitud y tipos de caracteres
✔ Validación robusta de inputs
✔ Manejo global de errores
✔ API REST protegida con autenticación básica
✔ Estructura profesional escalable

---

## 🧱 Arquitectura

```id="x9m4t6"
Controller → Service → DTO → Config → Security
```

### 📂 Estructura del proyecto

```id="pjm7au"
src/main/java/easypassword

├── config              # Configuración de seguridad
├── controller          # Endpoints REST
├── dto                 # Objetos de transferencia de datos
├── exception           # Manejo global de errores
├── service             # Lógica de negocio
└── Application.java    # Punto de entrada
```

---

## 🔐 Seguridad

La API está protegida mediante **Basic Authentication**:

* Todos los endpoints requieren autenticación
* Credenciales definidas en `application.properties`
* CSRF desactivado para uso REST

Ejemplo:

```properties id="s3y1z2"
spring.security.user.name=admin
spring.security.user.password=********
```

---

## 📡 API Endpoint

### Generar contraseña

```http id="q7k3nb"
POST /api/password/generate
```

---

### 📥 Request

```json id="h2v1oe"
{
  "length": 12,
  "uppercase": true,
  "lowercase": true,
  "numbers": true,
  "symbols": true
}
```

---

### 📤 Response

```json id="z9dpw4"
{
  "password": "A9$dK2!pQx7Z"
}
```

---

## 🧪 Testing rápido

### Con curl

```bash id="r8gk1d"
curl -X POST http://localhost:8080/api/password/generate \
-u admin:password \
-H "Content-Type: application/json" \
-d '{"length":12,"uppercase":true,"lowercase":true,"numbers":true,"symbols":true}'
```

---

## 🧠 Decisiones técnicas

### 🔹 Seguridad

* Uso de `SecureRandom` en lugar de `Math.random()`
* Validación estricta de inputs
* Protección de endpoints con autenticación

---

### 🔹 Backend

* Separación clara de responsabilidades
* Uso de DTOs para desacoplar la API
* Manejo centralizado de errores

---

## ⚠️ Problemas resueltos

* Error 405 (Method Not Allowed) → uso correcto de POST
* Errores de importación → normalización de paquetes
* Seguridad inicial → implementación de Spring Security

---

## 📈 Roadmap

### 🔜 Próximas mejoras

* [ ] Autenticación con JWT
* [ ] Roles de usuario
* [ ] Rate limiting
* [ ] Logging avanzado
* [ ] Tests unitarios

---

### 🎨 Frontend (en progreso)

* [ ] Interfaz con React
* [ ] Formulario de generación
* [ ] Medidor de fuerza de contraseña
* [ ] Copiado automático

---


## 🛠️ Cómo ejecutar

```bash id="m2n7qx"
git clone <repo>
cd easypassword
./mvnw spring-boot:run
```

---

## 📌 Estado del proyecto

🚧 En desarrollo activo — evolucionando hacia aplicación fullstack

---

## 👨‍💻 Autor

Desarrollado por **Isidoro Gordillo**

---

## ⭐ Contribuciones

Si te interesa el proyecto, ¡no dudes en darle una estrella o sugerir mejoras!

---
