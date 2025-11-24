# 📱 INSTALACIÓN FRONTEND - REACT NATIVE EXPO
## Para computadoras Windows de la Universidad

---

## ⚠️ IMPORTANTE - LEER ANTES DE EMPEZAR

**Escenarios posibles en la universidad:**

### ✅ **Escenario 1: CON permisos de administrador**
- Sigue las instrucciones de instalación completa
- Todo funcionará sin problemas

### ⚠️ **Escenario 2: SIN permisos de administrador**
- **OPCIÓN A:** Pide al técnico/admin que instale Node.js
- **OPCIÓN B:** Usa Node.js portable (instrucciones incluidas)
- **OPCIÓN C:** Usa tu laptop personal si es posible

---

## 📋 REQUISITOS PREVIOS

### Lo que DEBE tener la computadora:
- ✅ Windows 10 o superior
- ✅ Mínimo 4GB RAM (8GB recomendado)
- ✅ 5GB de espacio libre en disco
- ✅ Conexión a Internet

---

## 🚀 OPCIÓN 1: INSTALACIÓN NORMAL (CON PERMISOS ADMIN)

### **Paso 1: Instalar Node.js**

1. **Descargar Node.js:**
   - Ir a: https://nodejs.org/
   - Descargar la versión **LTS** (Long Term Support)
   - Versión recomendada: **20.x o superior**

2. **Instalar Node.js:**
   ```
   - Ejecutar el instalador descargado
   - Click en "Next" en todas las opciones
   - Marcar la casilla "Automatically install the necessary tools"
   - Esperar a que termine (5-10 minutos)
   ```

3. **Verificar instalación:**
   ```cmd
   # Abrir CMD o PowerShell y ejecutar:
   node --version
   npm --version
   
   # Debería mostrar algo como:
   # v20.x.x
   # 10.x.x
   ```

---

### **Paso 2: Instalar Expo CLI (OPCIONAL - ya no es necesario)**

```cmd
# NO es necesario instalar Expo CLI globalmente
# npx lo descargará automáticamente cuando sea necesario
```

---

### **Paso 3: Instalar Dependencias del Proyecto**

1. **Abrir terminal en la carpeta del proyecto:**
   ```cmd
   # Navegar a la carpeta:
   cd C:\ruta\donde\esta\el\proyecto\frontend
   
   # Ejemplo:
   cd C:\Users\TuUsuario\Desktop\appMobile\frontend
   ```

2. **Instalar dependencias:**
   ```cmd
   npm install
   ```
   
   **⏳ ESTO PUEDE TARDAR 5-15 MINUTOS**
   
   Verás muchos mensajes en la terminal, es normal.

3. **Verificar que todo se instaló:**
   ```cmd
   # Deberías ver una carpeta node_modules/
   dir
   ```

---

### **Paso 4: Configurar la URL del Backend**

1. **Abrir el archivo:** `src/services/api.ts`

2. **Cambiar la URL según donde esté el backend:**

   ```typescript
   // Si el backend está en la MISMA computadora:
   const API_URL = 'http://localhost:8080/api';
   
   // Si el backend está en OTRA computadora de la red:
   const API_URL = 'http://192.168.X.X:8080/api';
   // Reemplazar 192.168.X.X con la IP de la compu del backend
   
   // Para encontrar la IP del backend:
   // En la compu del backend ejecutar: ipconfig
   // Buscar "Dirección IPv4"
   ```

---

### **Paso 5: Ejecutar el Proyecto**

```cmd
# Ejecutar el servidor de desarrollo:
npm start
```

**Se abrirá la interfaz de Expo en el navegador.**

---

### **Paso 6: Ver la App en el Teléfono**

1. **Instalar Expo Go en tu teléfono:**
   - Android: [Play Store - Expo Go](https://play.google.com/store/apps/details?id=host.exp.exponent)
   - iOS: [App Store - Expo Go](https://apps.apple.com/app/expo-go/id982107779)

2. **Escanear el QR:**
   - Aparecerá un QR code en la terminal/navegador
   - Android: Abre Expo Go → Scan QR Code
   - iOS: Abre la cámara → Escanea el QR

3. **La app se cargará en tu teléfono** 📱

---

## 🔧 OPCIÓN 2: SIN PERMISOS ADMIN (Node.js Portable)

### **Paso 1: Descargar Node.js Portable**

1. **Ir a:** https://nodejs.org/dist/
2. **Buscar la última versión LTS** (ejemplo: v20.10.0)
3. **Descargar:** `node-v20.x.x-win-x64.zip`

### **Paso 2: Extraer y Configurar**

1. **Extraer el ZIP** en una carpeta, ejemplo:
   ```
   C:\Users\TuUsuario\NodePortable\
   ```

2. **Agregar al PATH (temporal):**
   ```cmd
   # Abrir CMD en la carpeta del proyecto
   # Ejecutar (reemplaza la ruta):
   set PATH=C:\Users\TuUsuario\NodePortable;%PATH%
   
   # Verificar:
   node --version
   ```

3. **Continuar con Paso 3 de Opción 1** (instalar dependencias)

---

## 🛠️ OPCIÓN 3: USAR EXPO WEB (Sin instalar nada en la PC)

Si todo lo demás falla, puedes ejecutar en el navegador:

```cmd
npm start
# Cuando aparezca el menú, presiona 'w' para abrir en web
```

La app se abrirá en el navegador (funcionalidad limitada pero sirve para demostrar).

---

## 📱 EJECUTAR EN EMULADOR ANDROID (Opcional - Avanzado)

**⚠️ REQUIERE Android Studio (20GB+ de instalación)**

Solo si es absolutamente necesario:

1. **Instalar Android Studio:**
   - Descargar: https://developer.android.com/studio
   - Instalar con configuración por defecto
   - Tardaría 1-2 horas

2. **Crear un emulador:**
   - Abrir Android Studio
   - Tools → Device Manager
   - Create Device → Pixel 5
   - Descargar imagen del sistema

3. **Ejecutar con el emulador:**
   ```cmd
   npm start
   # Presionar 'a' para Android
   ```

**❌ NO RECOMENDADO para computadoras de universidad (muy pesado)**

---

## 🔥 COMANDOS IMPORTANTES

### Comandos básicos:

```cmd
# Instalar dependencias
npm install

# Ejecutar proyecto
npm start

# Limpiar caché (si hay problemas)
npm start -- --clear

# Ver opciones
npm start -- --help
```

### En el menú de Expo:

```
› Press a │ open Android
› Press i │ open iOS simulator
› Press w │ open web

› Press r │ reload app
› Press m │ toggle menu
› Press ? │ show all commands
```

---

## ❗ SOLUCIÓN DE PROBLEMAS COMUNES

### **Error: "node no se reconoce como comando"**
```
Solución:
1. Node.js no está instalado correctamente
2. Reinicia la terminal/CMD
3. O usa Node.js portable (Opción 2)
```

### **Error: "Cannot find module"**
```cmd
# Solución:
npm install
```

### **Error: "Puerto 8081 en uso"**
```cmd
# Solución:
npm start -- --port 8082
```

### **Error: "EACCES permission denied"**
```
Solución:
1. Ejecutar CMD como administrador
2. O usar Node.js portable (Opción 2)
```

### **La app no se conecta al backend**
```
Solución:
1. Verificar que el backend esté corriendo
2. Verificar la URL en src/services/api.ts
3. Verificar que ambos estén en la misma red WiFi
4. Desactivar firewall temporalmente
```

### **QR code no aparece**
```
Solución:
1. Verificar conexión a Internet
2. npm start -- --tunnel
```

### **Error: "npm ERR! ERESOLVE"**
```cmd
# Solución:
npm install --legacy-peer-deps
```

---

## 📝 CHECKLIST DE VERIFICACIÓN

Antes de ejecutar, verifica:

- [ ] ✅ Node.js instalado (ejecuta: `node --version`)
- [ ] ✅ npm instalado (ejecuta: `npm --version`)
- [ ] ✅ Dependencias instaladas (existe carpeta `node_modules/`)
- [ ] ✅ Backend corriendo en otra terminal/PC
- [ ] ✅ URL del backend configurada en `src/services/api.ts`
- [ ] ✅ Teléfono con Expo Go instalado
- [ ] ✅ Ambos dispositivos en la misma red WiFi

---

## 🎯 FLUJO RÁPIDO PARA LA UNIVERSIDAD

### Primera vez (setup inicial):
```cmd
# 1. Instalar Node.js (una sola vez)
# Descargar de: https://nodejs.org/

# 2. Navegar al proyecto
cd C:\ruta\del\proyecto\frontend

# 3. Instalar dependencias (una sola vez)
npm install

# 4. Configurar URL del backend
# Editar: src/services/api.ts
```

### Cada vez que necesites ejecutar:
```cmd
# 1. Abrir terminal en la carpeta frontend
cd C:\ruta\del\proyecto\frontend

# 2. Iniciar el proyecto
npm start

# 3. Escanear QR con Expo Go en el teléfono
```

---

## 💡 TIPS Y RECOMENDACIONES

### Para la presentación:
1. ✅ **Llega 15-20 minutos antes** para configurar
2. ✅ **Prueba todo el día anterior** en casa
3. ✅ **Ten el backend corriendo primero**
4. ✅ **Usa tu teléfono personal** (más confiable)
5. ✅ **Ten un plan B:** Screenshots/video de la app funcionando

### Si falla todo:
1. **Plan B:** Ejecutar en modo web (`npm start` → presionar 'w')
2. **Plan C:** Mostrar capturas/video pregrabado
3. **Plan D:** Ejecutar desde tu laptop si la llevas

### Para evitar problemas:
- ✅ Verifica la conexión WiFi de la universidad
- ✅ Ten los instaladores descargados en un USB
- ✅ Anota la IP del backend antes de ir
- ✅ Prueba en casa con la misma configuración

---

## 📞 INFORMACIÓN DE CONTACTO

### Recursos útiles:
- **Documentación Expo:** https://docs.expo.dev/
- **Documentación React Native:** https://reactnative.dev/
- **Stack Overflow:** https://stackoverflow.com/questions/tagged/expo

### Comandos de emergencia:
```cmd
# Si todo falla, resetear completamente:
rmdir /s /q node_modules
del package-lock.json
npm install
npm start -- --clear
```

---

## ✅ RESUMEN EJECUTIVO

**Lo mínimo que necesitas:**
1. Node.js instalado
2. `npm install` ejecutado
3. Backend corriendo
4. `npm start` ejecutado
5. Expo Go en el teléfono

**Tiempo estimado total:**
- Primera instalación: 30-45 minutos
- Ejecuciones posteriores: 2-3 minutos

**¡Buena suerte en la presentación! 🚀**

---

## 📅 ÚLTIMA ACTUALIZACIÓN
**Fecha:** Noviembre 2025
**Versión de Node.js recomendada:** 20.x LTS
**Versión de Expo:** SDK 54
