
### Projeto final unidade 2

# Documentação
# Projeto do módulo UP-JV-003
## Enunciado
Crie uma aplicação que simule uma app para a locação de veículos. Os clientes podem alugar três tipos diferentes de veículos sendo pequeno, médio e SUV. O preço base da diária do aluguel de um veículo é 100 reais para carro pequeno, 150 para médio e 200 para SUV. Os clientes de um aluguel podem ser pessoas físicas ou jurídicas, pessoas físicas tem desconto de 5% caso o aluguel tenha mais de 5 diárias, já pessoas jurídicas tem 10% de desconto caso o aluguel tenha mais de 3 diárias.
Crie a classe Aluguel que deve receber um Veículo, um Cliente e uma quantidade de dias para esse aluguel, com essas informações, a classe deve calcular qual é o valor final do aluguel.
Use a classe Aplicação para criar seu método main e demonstrar o funcionamento do seu código.
Coloque no campo de resposta o link do GitHub com o seu projeto.
## Entrega
A entrega deverá ser feita fornecendo o link Github do projeto (link único para o grupo).
- Prazo:  01/08
## Descrição das classes
### Cliente
A classe Cliente é uma classe abstrata com os atributos:
- 	nome -> do tipo String;
- 	taxa de desconto -> do tipo BigDecimal, formato 9.99;
- 	diárias mínimas para desconto -> tipo Integer.
### ClientePessoaFísica e ClientePessoaJurídica
Tem apenas o construtor para permitir obter o valor do desconto em função do tipo de pessoa (física ou jurídica) e quantidade mínima de diárias para obtenção do desconto.
- 	Descontos x diárias
- 	pessoas físicas tem desconto de 5% caso o aluguel tenha mais de 5 diárias;
- 	pessoas jurídicas tem 10% de desconto caso o aluguel tenha mais de 3 diárias. 
### Veiculo
A classe Veiculo é classe abstrata com os atributos:
- 	valor da diária do aluguel -> do tipo BigDecimal, no formato 999;
### VeiculoPequeno, VeiculoMedio e VeiculoSuv
Tem apenas o construtor para permitir obter o valor da diária do aluguel em função do tipo do veículo. Valor das diárias de aluguel:
- Carros pequenos -> diária de R$ 100,00;
- Carros médios     -> diária de R$ 150,00;
- Carros SUV         -> diária de R$ 200,00
### Aluguel
A classe Aluguel calcula o valor total do aluguel em função do tipo do cliente, tipo do veículo e quantidade de diárias de aluguel. Recebe como parâmetro, Cliente, Veiculo e número de diárias; e tem como atributos:
- Cliente -> classe Cliente;
- Veiculo -> classe Veiculo;
- Diárias   -> número de diárias de aluguel.





