# Módulo de Pagos Seguro - Spring Boot (Taller Semana 5)

[cite_start]Este proyecto implementa un sistema de gestión de pagos diseñado bajo una arquitectura por capas, con un enfoque estricto en el **diseño seguro**, el **encapsulamiento** y el uso correcto de **modificadores de acceso**[cite: 3, 5].

## 🎯 Objetivo del Proyecto
[cite_start]Diseñar e implementar un módulo de pagos que garantice la integridad de los datos, evitando manipulaciones indebidas del monto o del estado de los pagos desde capas externas[cite: 4, 15].

## 🛠️ Tecnologías Utilizadas
* **Java 17+**
* **Spring Boot 3.x** (Spring Web)
* **Maven**
* **Postman** (para pruebas de endpoints)

## 🏗️ Arquitectura y Estructura
[cite_start]El proyecto se organiza en tres paquetes principales para asegurar la separación de responsabilidades[cite: 20, 21, 22]:
1. [cite_start]**`controller`**: Expone los servicios mediante una API REST[cite: 45].
2. [cite_start]**`service`**: Contiene la lógica de coordinación y persistencia en memoria[cite: 38].
3. [cite_start]**`model`**: Define las entidades y la lógica de negocio intrínseca[cite: 24].

## 🔒 Implementación de Seguridad y Encapsulamiento
[cite_start]Siguiendo los requerimientos técnicos del taller, se aplicaron las siguientes reglas[cite: 31, 53]:
* [cite_start]**Atributos Privados**: Todos los campos en `Pago` y `Pedido` son `private`[cite: 32].
* [cite_start]**Sin Setters Públicos**: Se omitieron setters para `monto` y `estado` para evitar cambios manuales externos[cite: 33, 34].
* [cite_start]**Lógica Interna**: El estado del pago solo puede cambiar a "PROCESADO" mediante el método público `procesarPago()`, el cual invoca validaciones privadas[cite: 35, 37].
* [cite_start]**Acceso de Paquete (Default)**: El método `buscarPagoPorId` en el Service no tiene modificador explícito para limitar su uso únicamente dentro del paquete de servicios[cite: 43].
* [cite_start]**Lista Protegida**: La lista de pagos es `private` y el Service solo entrega copias o acceso controlado, impidiendo que el Controller la manipule directamente[cite: 40, 44].

## 🚀 Pruebas de la API
La API está configurada para funcionar en el puerto **9090**. Los endpoints disponibles son:

* [cite_start]**GET `/pagos`**: Lista todos los pagos registrados (incluyendo los pre-cargados en el código)[cite: 48, 55].
* **POST `/pagos`**: Registra un nuevo pago. [cite_start]El sistema valida el monto y cambia el estado a "PROCESADO" automáticamente[cite: 47, 10, 14].

## 📝 Parte de Análisis (Obligatoria)

### 1. ¿Qué atributos decidieron proteger y por qué?
[cite_start]Se protegieron todos los atributos de las clases `Pago` e `id`, `monto`, `fecha`, `estado` y `pedido`[cite: 26, 27, 28, 29, 30]. [cite_start]La razón es garantizar que la integridad de los datos financieros no sea alterada accidentalmente por capas externas y asegurar que el objeto sea el único responsable de su propio estado[cite: 15].

### 2. ¿Por qué el estado no debe tener setter público?
[cite_start]Para evitar que el estado sea cambiado a "PROCESADO" manualmente sin que se hayan cumplido las reglas de negocio (como la validación del monto)[cite: 18, 33]. [cite_start]El cambio de estado debe ser una consecuencia de un proceso controlado (`procesarPago()`)[cite: 35].

### 3. ¿Qué ventaja tiene declarar métodos sin modificador (default)?
Permite aplicar el principio de visibilidad de paquete (*package-private*). [cite_start]La ventaja es que el método es accesible para pruebas o servicios dentro del mismo paquete, pero queda oculto para el `Controller`, reduciendo el acoplamiento y la exposición innecesaria de métodos internos[cite: 43, 63].

### 4. ¿Qué pasaría si todos los atributos fueran públicos?
[cite_start]Se rompería el principio de encapsulamiento[cite: 6]. [cite_start]Cualquier parte del programa podría modificar el monto a valores inválidos o alterar el estado del pago sin control, haciendo que el sistema sea inseguro, propenso a errores y fácil de manipular indebidamente[cite: 64].

### 5. ¿Dónde debe vivir la lógica de negocio y por qué?
[cite_start]Debe vivir en las capas de **Model** y **Service**[cite: 65]. [cite_start]El `Controller` debe ser "delgado" y solo actuar como puerta de enlace[cite: 52]. [cite_start]Al centralizar la lógica en el Service y el Modelo, el código es más fácil de mantener, reutilizar y proteger contra cambios no autorizados en el flujo del negocio[cite: 70].

---
**Equipo de trabajo:**
* David Fernando Ramírez de la Parra
* Juan Felipe Mora Revelo