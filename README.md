# 🪙 Conversor de Moedas Fantasy (Java GUI)

Uma aplicação desktop interativa desenvolvida em Java que simula um conversor de moedas do mundo real adaptado para economias fictícias de jogos (como Rupees de *The Legend of Zelda* e Gil de *Final Fantasy*). 

O projeto conta com um motor de simulação que aplica flutuações de inflação dinâmicas a cada conversão realizada.

---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Java SE**: Linguagem principal do projeto.
* **Java Swing**: Construção da interface gráfica do usuário (GUI) de forma nativa.
* **Programação Orientada a Objetos (POO)**: Encapsulamento de propriedades e métodos de cálculo.
* **Tratamento de Exceções**: Implementação de blocos `try-catch` para evitar falhas de execução (`NumberFormatException`) caso o usuário digite caracteres inválidos.
* **Simulação Estocástica**: Uso da classe `Random` para gerar taxas de inflação flutuantes em tempo real.

---

## ⚙️ Características Técnicas do Algoritmo

### 1. Sistema Dinâmico de Inflação
Diferente de conversores estáticos, este software implementa um algoritmo que gera uma variação percentual de mercado simulada entre **-3% e +5%** a cada clique do usuário, imitando a volatilidade de uma economia real.

```java
private double calcularInflacao(double min, double max) {
    return min + (max - min) * rand.nextDouble();
}
```

### 2. Interface Assíncrona e Responsiva
A inicialização da interface gráfica utiliza o gerenciamento de threads do Swing através do `SwingUtilities.invokeLater`, garantindo que a renderização da janela ocorra de forma segura na thread de eventos (EDT), evitando travamentos na interface.

---

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **JDK (Java Development Kit)** instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com
   ```
3. Abra o projeto em sua IDE de preferência (VS Code, IntelliJ ou Eclipse).
4. Execute o arquivo principal da aplicação.
