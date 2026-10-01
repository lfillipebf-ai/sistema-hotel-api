# Sistema Hotel API

API REST para gerenciamento de um hotel, desenvolvida como projeto educacional e de portfólio.

## Tecnologias
Java 17 · Spring Boot 3.5.6 · Spring Data JPA · PostgreSQL · Maven · Docker · REST API

## Funcionalidades
- Cadastro de hóspedes
- Cadastro de quartos e categorias
- Controle de disponibilidade
- Reservas, check-in e check-out
- Cancelamento de reservas
- Consulta de reservas por período
- Persistência em PostgreSQL

## Execução
```bash
docker compose up -d
cd backend
mvn spring-boot:run
```
API: `http://localhost:8080`

## Endpoints
- GET/POST `/api/hospedes`
- GET/POST `/api/categorias`
- GET/POST `/api/quartos`
- GET `/api/reservas`
- GET `/api/reservas/periodo?inicio=...&fim=...`
- POST `/api/reservas`
- PATCH `/api/reservas/{id}/check-in`
- PATCH `/api/reservas/{id}/check-out`
- PATCH `/api/reservas/{id}/cancelar`

**Autor:** Luis Fillipe Backer Faria  
**GitHub:** https://github.com/lfillipebf-ai
