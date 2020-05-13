# Checkout do jogo Jokenpo aqui!
[Jokenpo!](https://gitlab.com/celiberato/jokenpo)

# Como testar a API?

#### Instale o software Postman:
https://www.postman.com/downloads/

#### Importe o arquivo exportado do postman, no seguinte link:
https://gitlab.com/celiberato/jokenpo/-/blob/master/postman/jokenpo.postman_collection.json

# Como executar teste untários:

#### Instale a última versão do eclipse spring tools suite 4
https://spring.io/tools

#### Clone o projeto para uma pasta do disco
https://gitlab.com/celiberato/jokenpo

#### Execute o maven update do projeto

#### Execute o maven install na interface

#### Execute os testes unitários no eclipse


# Documentação do Software

JOGO JOKENPO
===================
Índice Analítico
----------------
* 1. [Introdução](#1-introdução)
    * 1.1 [Finalidade](#11-finalidade)
    * 1.2 [Escopo](#12-escopo)
    * 1.3 [Definições, Acrônimos e Abreviações](#13-definições-acrônimos-e-abreviações)
    * 1.4 [Referências](#14-referências)
    * 1.5 [Visão Geral](#15-visão-geral)
* 2. [Representação da Arquitetura](#2-representação-da-arquitetura)
* 3. [Metas e Restrições de Arquitetura](#3-metas-e-restrições-de-arquitetura)
* 4. [Visão de Casos de Uso](#4-visão-de-casos-de-uso)
    * 4.1 [Realizações de Casos de Uso](#41-realizações-de-casos-de-uso)
* 5. [Visão Lógica](#5-visão-lógica)
    * 5.1 [Visão Geral](#51-visão-geral)
    * 5.2 [Pacotes de Design Significativos do Ponto de Vista da Arquitetura](#52-pacotes-de-design-significativos-do-ponto-de-vista-da-arquitetura)
* 6. [Visão de Processos](#6-visão-de-processos)
* 7. [Visão de Implantação](#7-visão-de-implantação)
* 8. [Visão de Implementação](#8-visão-de-implementação)
    * 8.1 [Visão Geral](#81-visão-geral)
    * 8.2 [Camadas](#82-camadas)
* 9. [Visão de Dados (opcional)](#9-visão-de-dados-opcional)
* 10. [Tamanho e Desempenho](#10-tamanho-e-desempenho)
* 11. [Qualidade](#11-qualidade)

Documento de Arquitetura de Software
------------------------------------

## 1. Introdução

Escrever um programa que analise o resultado de múltiplos jogadores em um jogo de jokenpo, utilizando técnicas de programação de forma que a solução seja resiliente para possíveis mudanças como por exemplo adicionar e remover jogadas, e inserir e remover novos jogadores.

### 1.1 Finalidade

Este documento apresenta uma visão geral abrangente da arquitetura do sistema e utiliza uma série de visões arquiteturais diferentes para ilustrar os diversos aspectos do sistema. Sua intenção é capturar e transmitir as decisões significativas do ponto de vista da arquitetura que foram tomadas em relação ao sistema.

### 1.2 Escopo

Os jogadores deverão informar as entradas através das jogadas e o sistema deverá indicar qual o jogador ganhador. 
As entradas das jogadas deverão ser disponibilizadas através de APIs REST, além da aplicação disponibilizar APIs para realização do cadastro dos jogadores e das jogadas também ter a possibilidade de consulta-los e exclui-los.

### 1.3 Definições, Acrônimos e Abreviações

JOKEMPO: 
Papel, tesoura ouA pedra, também chamado em algumas regiões do Brasil de jokempô, é um jogo de mãos recreativo e simples para duas ou mais pessoas, que não requer equipamentos nem habilidade.

No Janken-pon, os jogadores devem simultaneamente esticar a mão, na qual cada um formou um símbolo (que significa pedra, papel ou tesoura). Então, os jogadores comparam os símbolos para decidir quem ganhou, da seguinte forma:

Pedra ganha da tesoura (amassando-a ou quebrando-a).
Tesoura ganha do papel (cortando-o).
Papel ganha da pedra (embrulhando-a).
A pedra é simbolizada por um punho fechado; a tesoura, por dois dedos esticados; e o papel, pela mão aberta. Caso dois jogadores façam o mesmo gesto, ocorre um empate, e geralmente se joga de novo até desempatar. Este jogo possui uma única regra: não é permitido mostrar pedra duas vezes seguidas.


### 1.4 Referências

#### Wiki Jokenpo: https://pt.wikipedia.org/wiki/Pedra,_papel_e_tesoura

### 1.5 Visão Geral



## 2. Representação da Arquitetura

*[Esta seção descreve qual é a arquitetura de software do sistema atual e como ela é representada. Nas Visões de Casos de Uso, Lógica, do Processo, de Implantação e de Implementação, este documento enumera as visões necessárias e, para cada uma delas, explica os tipos de elementos do modelo que contém.]*

## 3. Metas e Restrições de Arquitetura

- A linguagem a ser utilizada deve ser: Kotlin ou Java
- Os microservices devem ser desenvolvidos utilizando o framework Spring Boot
- Para gerenciamento de dependência deve ser utilizado o Gradle
- Para os testes unitários/API deve ser utilizado o JUnit


## 4. Visão de Casos de Uso

Os casos de uso do Jokenpo são:

- Iniciar Partida

- Adicinar Jogador

- Remover Jogador

- Adicionar Jogada

- Remover Jogada

- Obter resultado partilha

### 4.1 Realizações de Casos de Uso

#### Cenário 1
Participantes: José, Fábio e Marcela

Os 3 participantes contam até 3 e jogam os objetos:

### (1) José joga a 'PEDRA'
### (2) Fábio joga a 'PAPEL'
### (3) Marcela joga a 'TESOURA'

Resultado: José ganhou!

#### Cenário 2
Participantes: José, Fábio e Marcela

Os 3 participantes contam até 3 e jogam os objetos:

### (1) José joga a 'PAPEL'
### (2) Fábio joga a 'PAPEL'
### (3) Marcela joga a 'TESOURA'

Resultado: Empate entre José e Fábio

#### Cenário 3
Participantes: José, Fábio e Marcela

Os 3 participantes contam até 3 e jogam os objetos:

### (1) José joga a 'TESOURA'
### (2) Fábio joga a 'TESOURA'
### (3) Marcela joga a 'PAPEL'

Resultado: Marcela ganhou!

## 5. Visão Lógica

A visualização lógica do projeto JOKENPO é composta de 3 pacotes principais: API de Interface com o Usuário, Serviços de Negócios e Objetos de Negócios.

O Pacote de API de Interface com o Usuário disponibiliza o acesso a todas as APIs expostas pelo Jokenpo.

O Pacote de Serviços de Negócios implementa as regras para o devido funcionamento do jogo.

O Pacote de Objetos de Negócios inclui classes de entidade para os jogadores, jogadas, partidas, resultado da partida.

### 5.1 Visão Geral

- Camada de API: acessa somente a camada de serviço e modelo
- Camada de Serviços: acessa os repositórios, modelos e outros serviços da aplicação. Não acessa API.
- Camada de Modelo: acessa outros modelos. Não acessa APIs nen Serviços


### 5.2 Pacotes de Design Significativos do Ponto de Vista da Arquitetura

- Os pacotes principais do jogo são:
    - br.com.celiberato.jokenpo:
        - component
        - configuration
        - constants
        - controllers
        - domain
        - exception
        - exception handler
        - services
        - tests
        - utils

## 6. Visão de Processos

- Não se Aplica

## 7. Visão de Implantação

O projeto deve ser implantado na nuvem para testes, podendo ser em implentado em provedor de livre escolha. O projeto deve ser implantado como um microserviço.

## 8. Visão de Implementação

- Ferramentas de desenvolvimento: Eclipse (Spring Tools Suite 4), Postman, Lombok, Maven, Tomcat, LInux, Docker, Postgres

### 8.1 Visão Geral


### 8.2 Camadas

- API
- Serviços
- Modelo

## 9. Visão de Dados (opcional)

- Não se Aplica

## 10. Tamanho e Desempenho

- Não é requisito do projeto nenhum tipo de contingência, como balanceamento de carga.

## 11. Qualidade

É requisito dos projetos os seguintes pontos:

- Conhecimento técnico
- Estílo de código
- Conhecimentos de arquiteturas
- Padrões de programação
- Boas práticas
