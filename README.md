# 🎯 JobTrack API

![Java](https://img.shields.io/badge/Java-21+-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql)
![H2](https://img.shields.io/badge/H2-In%20Memory-orange?logo=h2)
![Lombok](https://img.shields.io/badge/Lombok-Reduce%20Boilerplate-pink?logo=lombok)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

> **Uma API REST moderna e robusta para gerenciamento de candidaturas e vagas de emprego**

A **JobTrack API** é uma solução completa desenvolvida em Spring Boot para auxiliar profissionais no acompanhamento de suas candidaturas de emprego. Com uma arquitetura limpa e bem estruturada, oferece todas as funcionalidades necessárias para organizar e monitorar o progresso das aplicações em diferentes empresas.

## 🚀 Características Principais

### ✨ **Funcionalidades Core**
- 📝 **CRUD Completo** - Criar, listar, buscar, atualizar e deletar candidaturas
- 📊 **Status Tracking** - Acompanhamento detalhado do progresso das candidaturas
- 🏢 **Gestão de Empresas** - Organização por empresa e vaga
- 📅 **Controle de Datas** - Rastreamento de datas importantes e próximas ações
- 🔗 **URLs de Vagas** - Armazenamento de links para referência rápida

### 🛠️ **Tecnologias & Arquitetura**
- **Java 21** - Linguagem moderna com recursos avançados
- **Spring Boot 3.5.6** - Framework robusto e produtivo
- **Spring Data JPA** - Persistência de dados simplificada
- **Spring Validation** - Validação automática de dados
- **Lombok** - Redução significativa de código boilerplate
- **PostgreSQL** - Banco de dados principal para produção
- **H2 Database** - Banco em memória para desenvolvimento e testes
- **Maven** - Gerenciamento de dependências e build

### 🏗️ **Arquitetura Limpa**
- **Controller Layer** - Endpoints REST bem estruturados
- **Service Layer** - Lógica de negócio centralizada
- **Repository Layer** - Acesso a dados abstraído
- **DTO Pattern** - Transferência de dados tipada e segura
- **Exception Handling** - Tratamento global de erros
- **Validation** - Validação automática de entrada

## 📋 Status das Candidaturas

A API suporta os seguintes status para acompanhamento das candidaturas:

| Status | Descrição |
|--------|-----------|
| `PENDENTE` | Candidatura enviada, aguardando resposta |
| `TRIAGEM` | Em processo de triagem inicial |
| `TESTE` | Realizando testes técnicos |
| `ENTREVISTA` | Em processo de entrevistas |
| `AGUARDANDO_RETORNO` | Aguardando retorno da empresa |
| `OFERTA` | Recebeu proposta de trabalho |
| `RECUSADA` | Candidatura foi recusada |
| `CONTRATADO` | Candidato foi contratado |

## 🔌 Endpoints da API

### Base URL
```
http://localhost:8080/api/candidaturas
```

### 📖 **GET** `/api/candidaturas`
Lista todas as candidaturas cadastradas.

**Resposta:**
```json
[
  {
    "id": 1,
    "tituloVaga": "Desenvolvedor Java Senior",
    "empresa": "TechCorp",
    "statusCandidatura": "ENTREVISTA"
  }
]
```

### 🔍 **GET** `/api/candidaturas/{id}`
Busca uma candidatura específica por ID.

**Parâmetros:**
- `id` (Long) - ID da candidatura

**Resposta:**
```json
{
  "id": 1,
  "tituloVaga": "Desenvolvedor Java Senior",
  "empresa": "TechCorp",
  "statusCandidatura": "ENTREVISTA"
}
```

### ➕ **POST** `/api/candidaturas`
Cria uma nova candidatura.

**Body:**
```json
{
  "tituloVaga": "Desenvolvedor Java Senior",
  "empresa": "TechCorp",
  "dataCandidatura": "2024-01-15",
  "statusCandidatura": "PENDENTE"
}
```

**Validações:**
- `tituloVaga` - Obrigatório
- `empresa` - Obrigatório
- `dataCandidatura` - Obrigatório, não pode ser futura

### ✏️ **PUT** `/api/candidaturas/{id}`
Atualiza uma candidatura existente.

**Parâmetros:**
- `id` (Long) - ID da candidatura

**Body:**
```json
{
  "statusCandidatura": "ENTREVISTA",
  "urlVaga": "https://empresa.com/vaga/123",
  "proximaAcaoData": "2024-01-20"
}
```

### 🗑️ **DELETE** `/api/candidaturas/{id}`
Remove uma candidatura.

**Parâmetros:**
- `id` (Long) - ID da candidatura

**Resposta:** `204 No Content`

## 🛠️ Configuração e Instalação

### Pré-requisitos
- ☕ **Java 21+**
- 🍃 **Maven 3.6+**
- 🐘 **PostgreSQL 12+** (opcional para produção)

### 🚀 Executando a Aplicação

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/jobtrack-api.git
cd jobtrack-api
```

2. **Instale as dependências**
```bash
mvn clean install
```

3. **Execute a aplicação**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

### 🗄️ Banco de Dados

#### Desenvolvimento (H2)
A aplicação usa H2 em memória por padrão. Acesse o console em:
```
http://localhost:8080/h2-console
```

**Configurações:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

#### Produção (PostgreSQL)
Para usar PostgreSQL, configure as propriedades:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobtrack
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

## 🧪 Testando a API

### Usando cURL

**Criar candidatura:**
```bash
curl -X POST http://localhost:8080/api/candidaturas \
  -H "Content-Type: application/json" \
  -d '{
    "tituloVaga": "Desenvolvedor Java Senior",
    "empresa": "TechCorp",
    "dataCandidatura": "2024-01-15",
    "statusCandidatura": "PENDENTE"
  }'
```

**Listar candidaturas:**
```bash
curl -X GET http://localhost:8080/api/candidaturas
```

**Atualizar candidatura:**
```bash
curl -X PUT http://localhost:8080/api/candidaturas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "statusCandidatura": "ENTREVISTA",
    "urlVaga": "https://techcorp.com/vaga/123"
  }'
```

### Usando Postman/Insomnia
Importe a collection disponível em `/docs/postman-collection.json`

## 📊 Tratamento de Erros

A API possui tratamento global de erros com respostas padronizadas:

### Erro 404 - Recurso Não Encontrado
```json
{
  "message": "Recurso não encontrado",
  "errors": ["Candidatura com o ID 999 não encontrada"],
  "status": 404
}
```

### Erro 400 - Validação
```json
{
  "message": "Validation failed",
  "errors": ["O nome da vaga é obrigatório."],
  "status": 400
}
```

## 🏆 Pontos Fortes da API

### 🎯 **Experiência do Desenvolvedor**
- **Documentação Clara** - README detalhado e exemplos práticos
- **Validação Automática** - Validação de entrada com mensagens claras
- **Tratamento de Erros** - Respostas padronizadas e informativas
- **Código Limpo** - Arquitetura bem estruturada e fácil manutenção

### ⚡ **Performance & Escalabilidade**
- **Spring Boot** - Framework otimizado para produção
- **JPA/Hibernate** - ORM eficiente com cache automático
- **Connection Pooling** - Gerenciamento otimizado de conexões
- **Lazy Loading** - Carregamento sob demanda de relacionamentos

### 🔒 **Segurança & Confiabilidade**
- **Validação Rigorosa** - Validação de entrada em múltiplas camadas
- **Exception Handling** - Tratamento global de exceções
- **Transações ACID** - Consistência de dados garantida
- **Prepared Statements** - Proteção contra SQL Injection

### 🛠️ **Manutenibilidade**
- **Arquitetura em Camadas** - Separação clara de responsabilidades
- **DTO Pattern** - Contratos bem definidos entre camadas
- **Lombok** - Redução de código boilerplate
- **Convenções Spring** - Padrões estabelecidos e reconhecidos

### 📈 **Extensibilidade**
- **Modular Design** - Fácil adição de novas funcionalidades
- **Interface-based** - Desacoplamento para testes e extensões
- **Configuration Properties** - Configuração flexível por ambiente
- **Plugin Architecture** - Suporte a extensões via Spring Boot Starters

## 🗂️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/jobtrack/api/
│   │   ├── controller/          # Controladores REST
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── enums/               # Enumerações
│   │   ├── exceptions/          # Tratamento de exceções
│   │   ├── model/               # Entidades JPA
│   │   ├── repository/          # Repositórios de dados
│   │   ├── service/             # Lógica de negócio
│   │   └── JobTrackApiApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/                        # Testes unitários e integração
```

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor

**Swetony Ancelmo**
- GitHub: [Swetony Ancelmo](https://github.com/swetonyancelmo)
- LinkedIn: [Swetony Ancelmo](https://www.linkedin.com/in/swetony-ancelmo/?trk=opento_sprofile_details)

## 🙏 Agradecimentos

- Meus pais
- Spring Boot Team pela excelente framework
- Comunidade Java pelo ecossistema robusto
- Todos os contribuidores que ajudaram a melhorar este projeto

---

<div align="center">

**⭐ Se este projeto foi útil para você, considere dar uma estrela! ⭐**

Made with ❤️ and ☕

</div>
