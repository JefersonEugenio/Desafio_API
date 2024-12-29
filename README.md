# ViaCEP
Webservice gratuito de alto desempenho para consulta de Código de Endereçamento Postal (CEP) do Brasil.
## Descrição do projeto
O objetivo do desafio proposto pela empresa DB é permitir que você demonstre seus conhecimentos em Automação de Testes, com foco em conceitos como Arquitetura de Automação de API, Programação Orientada a Objetos, Design Patterns e Clean Code. O desafio deve ser resolvido de maneira completa, utilizando todo o seu conhecimento. O projeto consiste em desenvolver uma automação de API para o URI ["https://viacep.com.br/ws/CEP/json"](https://viacep.com.br/).

## Índice
1. [Sobre o projeto](#sobre-o-projeto)
2. [Funcionalidades do projeto](#funcionalidades-do-projeto)
3. [Tecnologias usadas](#tecnologias-usadas)
4. [Como Executar](#como-executar)
5. [Autor](#autor)

## Sobre o projeto
A aplicação facilita a obtenção de dados como rua, bairro, cidade, estado, entre outros, fornecendo um recurso útil para aplicações que necessitam validar ou buscar informações de localização.

## Funcionalidades do projeto
* **Teste de contrato:** Valida se a resposta da API segue o contrato especificado (estrutura esperada).
* **Teste de funcional:** Garante que os dados retornados pela API estejam corretos para diferentes entradas.
* **Teste de performance:** Avalia o desempenho da API em cenários variados, incluindo alta carga.

## Tecnologias usadas
### Liguagem de programação:
* [JAVA (JDK 21)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
### Ferramenta:
* [Intellij IDEA](https://www.jetbrains.com/pt-br/idea/)
* [POSTMAN](https://www.postman.com/)
* [Allure Reports](https://docs.qameta.io/allure/) (para geração de relatórios

## Como Executar

### Pré-requisitos
Antes de começar, você vai precisar ter instaladas em sua máquina as seguintes ferramentas: 
* Git
* Maven
* JDK 21
<p>Além disso, é recomendado usar uma IDE como IntelliJ IDEA para facilitar o desenvolvimento.</p>

### Passo a passo

#### 1. Instalar o Allure, siga o passo a passo abaixo:
* Abrir PowerShell e executar o comando: <br>
``` Set-ExecutionPolicy RemoteSigned -Scope CurrentUser ``` <br>
- Vai aparecer algumas opções: "[S] Sim [A] Sim para Todos [N] Não [T] Não para Todos [U] Suspender [?] Ajuda (o padrão é 'N')". Digite [S] para 'Sim'. <br>
#### Executar o comando para instalar o Scoop: 
`` iex (new-object net.webclient).downloadstring('https://get.scoop.sh') `` <br>
- Vai aparecer mensagens indicando o progresso: "Initializing... Downloading... Creating shim... 'Scoop was installed successfully!'" <br>
#### Instalar o OpenSSH e o Git
* No PowerShell, execute os seguintes comandos: <br>
`` scoop install openssh
scoop install git `` <br>
- Vai iniciar o download, instalação e finalizar com 'done' para ambos os comandos. <br>
#### Instalar o Allure
* Execute o seguinte comando no PowerShell: <br>
`` scoop install allure ``
- Vai iniciar o download, instalação e finalizar com 'done'.

#### 2.Executar o projeto
1. Clone o repositório:
```bash
git clone https://github.com/JefersonEugenio/Desafio_API.git
cd Desafio_API
```
2. Abra o projeto na sua IDE.
3. Execute os testes:
* Navegue até `src/test/java/org/desafio/contrato` (ou funcional/performance)
* Execute os métodos de teste diretamente na IDE.
4. Para gerar relatórios:
* No terminal, execute o comando:
``` allure serve allure-results ```

## Autor
| [<img src="https://avatars.githubusercontent.com/u/122066021?v=4" width=115><br><sub>Jeferson Lopes Eugenio</sub>](https://github.com/JefersonEuenio) |
| :---: |
