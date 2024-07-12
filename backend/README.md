1. clonar proyecto
2. crear file env.properties en /src/main/resources
3. Escribir SECRET_KEY=Tu JWT secret

   El Jwt Secret puede generarse en https://jwtsecret.com/generate (longitud 32)

4. Asegurarse de que .gitignore contenga /src/main/resources/env.properties