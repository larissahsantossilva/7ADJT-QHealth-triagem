# 🧬 QHealth – Triagem  
Serviço responsável por **definir a prioridade de atendimento** do paciente com base em dados clínicos e de anamnese.

## 📝 Visão Geral  
O **QHealth – Triagem** é um microserviço que avalia as condições do paciente e determina se ele deve ser classificado como **preferencial** ou **usual** para o atendimento.  
Ele atua como peça central no fluxo de orquestração do QHealth, garantindo que pacientes com maior necessidade sejam atendidos com prioridade.

## 🛠 Funcionalidades  
- 🩺 **Definir prioridade de atendimento**: recebe informações de anamnese e dados básicos do paciente para determinar se o atendimento será **preferencial** ou **usual**.  
- ✅ **Validação de dados de entrada**: garante integridade das informações recebidas.  
- 🧪 **Logs e Monitoramento**: registra todo o processo para rastreabilidade.  
- ⚡ **Resposta em tempo real**: retorno imediato para os serviços que dependem da decisão de triagem.

## 🚀 Tecnologias Principais  
- **Java Spring Boot** – API REST moderna e escalável.  
- **Spring Data JPA** – persistência e consultas ao banco de dados.  
- **Swagger/OpenAPI** – documentação clara e interativa dos endpoints.  
- **JUnit** – testes automatizados para garantir confiabilidade.  
- **Docker** – containerização para fácil deploy e execução.
