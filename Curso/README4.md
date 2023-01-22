# Tópicos especiais em Java: Data-Hora

## Conceitos importantes
1. **Data-[hora] local:**
    1. ano-mês-dia-[hora] **sem fuso horário**
   2. [hora] opcional
2. Data-hora global
    1. ano-mês-dia-hora **com fuso horário**
3. Duração:
    1. tempo decorrido entre duas data-horas


### Representação de uma data-hora global
![](images/global-date.png)

Na imagem acima temos a diferença entre as horas em diferentes países. O resultado de
```text
2022-07-23T14:30:00Z
```
O Z no final representa o horário em londres. Por fim, temos o cálculo do sistema local, onde irá exibir a hora em 
cada país.

## Quando usar?
1. Data-[hora] local:
   1. Quando o **momento exato não interessa a pessoa de outro fuso horário.**
   2. Uso comum: sistemas de região única, Excel.
      1. Data de nascimento: "15/06/2001"
      2. Data-hora da venda: "13/08/2022" às 15:32" (presumindo não interessar o fuso horário)
2. Data-hora global:
   1. Quando o **momento exato interessa a pessoa de outro fuso horário.**
   2. Uso comum: sistemas multi-região, web.
      1. Quando será o sorteio? "21/08/2022 às 20h (horário de São Paulo)"
      2. Quando o comentário foi postado? "há 17 minutos"
      3. Quando foi realizada a venda? "13/08/2022 às 15:32 (horario de São Paulo)"
      4. Início e fim do evento? "21/08/2022 às 14h até 16h (horário de São Paulo)"


## Timezone (fuso horário)
1. **GMT - Greenwich Mean Time**
   1. **Horário de Londres**
   2. **Horário do padrão UTC - Coordinated Universal Time**
   3. **Também chamado de "Z" time, ou Zulu time**
2. **Outros fusos horários são relativos ao GMT/UTC:**
   1. **São Paulo: GMT-3**
   2. **Manaus: GMT-4**
   3. **Portugal: GMT+1**
3. **Muitas linguagens/tecnologias usam nomes para as timezones:**
   1. **"US/Pacific"**
   2. **"America/Sao_Paulo"**
   3. **etc.**

## Padrão ISO 8601
Padrão de horas em texto.

1. **Data-[hora] local:**
   1. 2022-07-21
   2. 2022-07-21T14:52
   3. 2022-07-21T14:52:09
   4. 2022-07-21T14:52:09.4073
2. **Data-hora global:**
   1. 2022-07-23T14:52:09Z
   2. 2022-07-23T14:52:09.254935Z
   3. 2022-07-23T14:52:09-03:00




[Voltar](../README.md)