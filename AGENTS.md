# AGENTS.md

## Multi-module Maven project (Spring Boot microservices)

```
Eureka-Server/        port 8761 — service discovery
Config-Server/        port 8083 — centralized config (reads from GitHub repo)
GATEWAY-Service/      port 8082 — Spring Cloud Gateway + JWT auth filter
Identity-Service/     no port set — auth (JPA, Security, JWT)
Rest-Employee/        config via Config-Server — Employee CRUD + Feign to Rest-Cuenta
Rest-Cuenta/          port 9003 — Cuenta CRUD, MySQL `bdPrueba`
Saludo-Service/       port 9001 — sample endpoint + Feign to jsonplaceholder
```

**Startup order:** `Eureka-Server` → `Config-Server` → everything else (any order after).

## Build & run

```powershell
# Build all
mvn clean package -DskipTests

# Run a single service (from its directory)
mvn spring-boot:run

# Or from root
mvn -pl Eureka-Server spring-boot:run
```

## Gateway routing (defined in `AppConfig.java`)

| Path | Target |
|---|---|
| `/api/employee/**` | `lb://Rest-Employee` |
| `/api/saludo/**` | `lb://Saludo-Service` |
| `/api/Cuenta/**` | `lb://Rest-Cuenta` |
| `/api/identity/**` | `lb://Identity-Service` |

**Open (no-auth) endpoints** (defined in `RouteValidator.java`): `/auth/register`, `/auth/token`, `/eureka`.

All other routes require a `Bearer` JWT token in the `Authorization` header, validated by `AuthenticationFilter` using a hardcoded secret (`JwtService.SECRET`).

## Key framework versions

- Java 21, Spring Boot 4.0.6 (most modules), Spring Cloud 2025.1.1 (most modules)
- `GATEWAY-Service`: Boot 3.3.5, Cloud 2023.0.3 (older)
- `Config-Server` & `Rest-Employee`: Cloud 2025.1.2
- JPA, MySQL (`mysql-connector-j`), OpenFeign, Eureka Client, Spring Security

## DB & config notes

- **Rest-Cuenta** points to `jdbc:mysql://localhost:3306/bdPrueba` (root/mysql), DDL auto-update.
- **Identity-Service** has no port or datasource configured in `application.properties` — likely deferred to env or defaults.
- **Rest-Employee** pulls config from Config-Server (`spring.config.import=optional:configserver:http://localhost:8083`).
- **Config-Server** serves from `https://github.com/IsmaelMatias-Ipa/Configuration-Clients.git` (branch `main`).

## Cross-service communication

- `Rest-Employee` → `Rest-Cuenta` via Feign (`ICuentaFeignclient` → `http://localhost:9003/api/cuenta/createCuenta`)
- `Saludo-Service` → external `https://jsonplaceholder.typicode.com/posts` via Feign (`PostFeignClient`)
- `Identity-Service` `AuthService` uses `JwtService` for token generation/validation

## Code style

- No Lombok — getters/setters written manually
- Underscore naming in fields (`cod_Employee`, `nom_Employee`)
- `cibertec.pe` base package (with `cibertec.pe.Rest_Cuenta` sub-package for the Cuenta module)
