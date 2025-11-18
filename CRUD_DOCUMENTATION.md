# Pruebas CRUD Postman - WorkableMobile

Este documento contiene las pruebas CRUD para cada entidad del backend, con ejemplos de JSON y explicaciones detalladas.

## Configuración Inicial


### 1. Variables de Entorno
Antes de empezar, configura las siguientes variables en Postman:
- `{{baseUrl}}` = `http://localhost:8080/api`
- `{{token}}` = Tu token JWT obtenido al hacer login

### 2. Obtener Token (Autenticación)


**Endpoint:** `POST {{baseUrl}}/auth/login`

```json
{
  "username": "admin",
  "password": "admin"
}
```

La respuesta contendrá un token JWT que debes copiar en la variable `{{token}}`

---

## USUARIOS (Users)

### 1. Crear Usuario (CREATE)

**Método:** `POST`  
**URL:** `{{baseUrl}}/users`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "username": "usuario_test",
  "email": "usuario@example.com",
  "password": "password123",
  "role": "COORDINADOR",
  "isActive": true
}
```

**Roles disponibles:**
- `ADMIN` - Acceso total
- `COORDINADOR` - Acceso limitado

**Respuesta esperada (201 Created):**
```json
{
  "id": 2,
  "username": "usuario_test",
  "email": "usuario@example.com",
  "role": "COORDINADOR",
  "active": true,
  "createdAt": "2025-11-14T10:30:00"
}
```

---

### 2. Obtener Todos los Usuarios (GET ALL)

**Método:** `GET`  
**URL:** `{{baseUrl}}/users`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Parámetros:** Ninguno

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "username": "admin",
    "email": "admin@example.com",
    "role": "ADMIN",
    "active": true,
    "createdAt": "2025-11-14T08:00:00"
  },
  {
    "id": 2,
    "username": "usuario_test",
    "email": "usuario@example.com",
    "role": "COORDINADOR",
    "active": true,
    "createdAt": "2025-11-14T10:30:00"
  }
]
```

---

### 3. Obtener Usuario por ID (GET BY ID)

**Método:** `GET`  
**URL:** `{{baseUrl}}/users/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "username": "admin",
  "email": "admin@example.com",
  "role": "ADMIN",
  "active": true,
  "createdAt": "2025-11-14T08:00:00"
}
```

---

### 4. Actualizar Usuario (UPDATE)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/users/path/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "username": "usuario_actualizado",
  "email": "usuario_nuevo@example.com",
  "password": "newpassword123",
  "role": "COORDINADOR",
  "isActive": true
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "username": "usuario_actualizado",
  "email": "usuario_nuevo@example.com",
  "role": "COORDINADOR",
  "active": true,
  "createdAt": "2025-11-14T10:30:00"
}
```

---

### 5. Desactivar Usuario (UPDATE con isActive=false)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/users/path/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "username": "usuario_actualizado",
  "email": "usuario_nuevo@example.com",
  "password": "newpassword123",
  "role": "COORDINADOR",
  "isActive": false
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "username": "usuario_actualizado",
  "email": "usuario_nuevo@example.com",
  "role": "COORDINADOR",
  "active": false,
  "createdAt": "2025-11-14T10:30:00"
}
```

---

### 6. Eliminar Usuario (DELETE)

**Método:** `DELETE`  
**URL:** `{{baseUrl}}/users/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "message": "Usuario eliminado exitosamente"
}
```

---

## CATEGORÍAS (Categories)

### 1. Crear Categoría (CREATE)

**Método:** `POST`  
**URL:** `{{baseUrl}}/categories`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Electrónica",
  "description": "Productos electrónicos en general",
  "active": true
}
```

**Respuesta esperada (201 Created):**
```json
{
  "id": 1,
  "name": "Electrónica",
  "description": "Productos electrónicos en general",
  "active": true
}
```

---

### 2. Obtener Todas las Categorías (GET ALL)

**Método:** `GET`  
**URL:** `{{baseUrl}}/categories`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Electrónica",
    "description": "Productos electrónicos en general",
    "active": true
  },
  {
    "id": 2,
    "name": "Ropa",
    "description": "Prendas de vestir",
    "active": true
  }
]
```

---

### 3. Obtener Categoría por ID (GET BY ID)

**Método:** `GET`  
**URL:** `{{baseUrl}}/categories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Electrónica",
  "description": "Productos electrónicos en general",
  "active": true
}
```

---

### 4. Actualizar Categoría (UPDATE)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/categories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Electrónica Actualizada",
  "description": "Productos electrónicos de calidad",
  "active": true
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Electrónica Actualizada",
  "description": "Productos electrónicos de calidad",
  "active": true
}
```

---

### 5. Desactivar Categoría (UPDATE con active=false)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/categories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Electrónica Actualizada",
  "description": "Productos electrónicos de calidad",
  "active": false
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Electrónica Actualizada",
  "description": "Productos electrónicos de calidad",
  "active": false
}
```

---

### 6. Eliminar Categoría (DELETE)

**Método:** `DELETE`  
**URL:** `{{baseUrl}}/categories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "message": "categoria eliminada exitosamente"
}
```

---

## SUBCATEGORÍAS (Subcategories)

### 1. Crear Subcategoría (CREATE)

**Método:** `POST`  
**URL:** `{{baseUrl}}/subcategories`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Celulares",
  "description": "Teléfonos celulares y accesorios",
  "active": true,
  "category": {
    "id": 1
  }
}
```

**Respuesta esperada (201 Created):**
```json
{
  "id": 1,
  "name": "Celulares",
  "description": "Teléfonos celulares y accesorios",
  "active": true,
  "category": {
    "id": 1,
    "name": "Electrónica",
    "description": "Productos electrónicos en general",
    "active": true
  }
}
```

---

### 2. Obtener Todas las Subcategorías (GET ALL)

**Método:** `GET`  
**URL:** `{{baseUrl}}/subcategories`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Celulares",
    "description": "Teléfonos celulares y accesorios",
    "active": true,
    "category": {
      "id": 1
    }
  },
  {
    "id": 2,
    "name": "Laptops",
    "description": "Computadoras portátiles",
    "active": true,
    "category": {
      "id": 1
    }
  }
]
```

---

### 3. Obtener Subcategoría por ID (GET BY ID)

**Método:** `GET`  
**URL:** `{{baseUrl}}/subcategories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Celulares",
  "description": "Teléfonos celulares y accesorios",
  "active": true,
  "category": {
    "id": 1
  }
}
```

---

### 4. Obtener Subcategorías por Categoría

**Método:** `GET`  
**URL:** `{{baseUrl}}/subcategories/category/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Celulares",
    "description": "Teléfonos celulares y accesorios",
    "active": true,
    "category": {
      "id": 1
    }
  },
  {
    "id": 2,
    "name": "Laptops",
    "description": "Computadoras portátiles",
    "active": true,
    "category": {
      "id": 1
    }
  }
]
```

---

### 5. Actualizar Subcategoría (UPDATE)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/subcategories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Celulares Actualizado",
  "description": "Teléfonos celulares premium",
  "active": true,
  "category": {
    "id": 1
  }
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Celulares Actualizado",
  "description": "Teléfonos celulares premium",
  "active": true,
  "category": {
    "id": 1
  }
}
```

---

### 6. Desactivar Subcategoría (UPDATE con active=false)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/subcategories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "Celulares Actualizado",
  "description": "Teléfonos celulares premium",
  "active": false,
  "category": {
    "id": 1
  }
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "Celulares Actualizado",
  "description": "Teléfonos celulares premium",
  "active": false,
  "category": {
    "id": 1
  }
}
```

---

### 7. Eliminar Subcategoría (DELETE)

**Método:** `DELETE`  
**URL:** `{{baseUrl}}/subcategories/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "message": "subcategoria eliminada exitosamente"
}
```

---

## PRODUCTOS (Products)

### 1. Crear Producto (CREATE)

**Método:** `POST`  
**URL:** `{{baseUrl}}/products`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "iPhone 14 Pro",
  "description": "Teléfono inteligente de última generación con cámara mejorada",
  "price": 999.99,
  "stock": 50,
  "active": true,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

**Respuesta esperada (201 Created):**
```json
{
  "id": 1,
  "name": "iPhone 14 Pro",
  "description": "Teléfono inteligente de última generación con cámara mejorada",
  "price": 999.99,
  "stock": 50,
  "active": true,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

---

### 2. Obtener Todos los Productos (GET ALL)

**Método:** `GET`  
**URL:** `{{baseUrl}}/products`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "iPhone 14 Pro",
    "description": "Teléfono inteligente de última generación",
    "price": 999.99,
    "stock": 50,
    "active": true,
    "category": {
      "id": 1
    },
    "subcategory": {
      "id": 1
    }
  },
  {
    "id": 2,
    "name": "Samsung Galaxy S22",
    "description": "Smartphone de alta gama",
    "price": 799.99,
    "stock": 30,
    "active": true,
    "category": {
      "id": 1
    },
    "subcategory": {
      "id": 1
    }
  }
]
```

---

### 3. Obtener Producto por ID (GET BY ID)

**Método:** `GET`  
**URL:** `{{baseUrl}}/products/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "iPhone 14 Pro",
  "description": "Teléfono inteligente de última generación",
  "price": 999.99,
  "stock": 50,
  "active": true,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

---

### 4. Obtener Productos por Categoría

**Método:** `GET`  
**URL:** `{{baseUrl}}/products/category/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "iPhone 14 Pro",
    "description": "Teléfono inteligente de última generación",
    "price": 999.99,
    "stock": 50,
    "active": true,
    "category": {
      "id": 1
    },
    "subcategory": {
      "id": 1
    }
  }
]
```

---

### 5. Obtener Productos por Subcategoría

**Método:** `GET`  
**URL:** `{{baseUrl}}/products/subcategory/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "name": "iPhone 14 Pro",
    "description": "Teléfono inteligente de última generación",
    "price": 999.99,
    "stock": 50,
    "active": true,
    "category": {
      "id": 1
    },
    "subcategory": {
      "id": 1
    }
  }
]
```

---

### 6. Actualizar Producto (UPDATE)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/products/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "iPhone 14 Pro Actualizado",
  "description": "Teléfono inteligente actualizado",
  "price": 899.99,
  "stock": 40,
  "active": true,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "iPhone 14 Pro Actualizado",
  "description": "Teléfono inteligente actualizado",
  "price": 899.99,
  "stock": 40,
  "active": true,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

---

### 7. Desactivar Producto (UPDATE con active=false)

**Método:** `PUT`  
**URL:** `{{baseUrl}}/products/1`  
**Headers:**
- `Authorization: Bearer {{token}}`
- `Content-Type: application/json`

**Body:**
```json
{
  "name": "iPhone 14 Pro Actualizado",
  "description": "Teléfono inteligente actualizado",
  "price": 899.99,
  "stock": 40,
  "active": false,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

**Respuesta esperada (200 OK):**
```json
{
  "id": 1,
  "name": "iPhone 14 Pro Actualizado",
  "description": "Teléfono inteligente actualizado",
  "price": 899.99,
  "stock": 40,
  "active": false,
  "category": {
    "id": 1
  },
  "subcategory": {
    "id": 1
  }
}
```

---

### 8. Eliminar Producto (DELETE)

**Método:** `DELETE`  
**URL:** `{{baseUrl}}/products/1`  
**Headers:**
- `Authorization: Bearer {{token}}`

**Respuesta esperada (200 OK):**
```json
{
  "message": "producto eliminada exitosamente"
}
```

---

## Notas Importantes

### Permisos Requeridos

- **Crear, Leer, Actualizar**: Requiere rol `ADMIN` o `COORDINADOR`
- **Eliminar**: Requiere rol `ADMIN`
- **Desactivar**: Requiere rol `ADMIN` o `COORDINADOR`

### Códigos de Estado HTTP

- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente
- `400 Bad Request` - Error en los datos enviados
- `403 Forbidden` - No tienes permisos para realizar esta acción
- `404 Not Found` - Recurso no encontrado
- `500 Internal Server Error` - Error en el servidor

### Tips para Pruebas

1. Siempre obtén el token primero haciendo login
2. Guarda los IDs de los recursos creados para usarlos en otras pruebas
3. Utiliza variables de Postman para reutilizar valores comunes
4. Verifica los permisos antes de cada operación
5. Prueba con datos inválidos para verificar la validación del backend

