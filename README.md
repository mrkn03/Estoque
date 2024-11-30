# Estoque de Produtos  

Projeto acadêmico desenvolvido para gerenciar um estoque de produtos utilizando Java. Este sistema foi desenvolvido com o objetivo de consolidar conhecimentos em Programação Orientada a Objetos (POO), versionamento de código e boas práticas de desenvolvimento.

---

## 📖 Descrição do Sistema  

O sistema **Estoque de Produtos** permite:  
- **Cadastrar Produtos:** Adicionar informações como nome, preço, código e quantidade.  
- **Gerenciar Estoque:** Adicionar, listar, atualizar e remover produtos utilizando o código como identificador.  
- **Persistir Dados:** Salvar e carregar dados em arquivos locais para manter o histórico.  

O projeto inclui **enumerações** para categorizar os produtos e **regras de negócio** para garantir a integridade do sistema.  

---

## 🛠️ Tecnologias e Ferramentas  

- **Linguagem:** Java  
- **Controle de Tarefas:** Jira Software  
- **Versionamento de Código:** Bitbucket  
- **Persistência de Dados:** Manipulação de arquivos com a classe `ArquivoUtils`.  

---

## 📊 Diagrama de Classe  

Abaixo está o diagrama UML criado para planejar as classes do sistema:  

![Diagrama de Classe UML](Diagrama_Uml.pdf)  

**Descrição das Classes:**  
1. **Produto**  
   - Atributos: `nome` (String), `preco` (double), `codigo` (int), `quantidade` (int).  
2. **Estoque**  
   - Contém a lista de produtos (`ArrayList<Produto>`).  
   - Métodos:  
     - `adicionarProduto(produto: Produto): void`  
     - `listarProdutos(): void`  
     - `removerProduto(codigo: int): void`  
     - `atualizarQuantidade(codigo: int, novaQuantidade: int): void`  
3. **ArquivoUtils**  
   - Responsável por salvar e carregar produtos em arquivos.  
   - Métodos:  
     - `salvarProdutos(produtos: ArrayList<Produto>): void`  
     - `carregarProdutos(): ArrayList<Produto>`  

---
