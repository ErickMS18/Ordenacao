## Descrição
O sistema analisa métricas de desempenho como número de comparações e movimentações realizadas por cada algoritmo em diferentes cenários de dados, permitindo uma avaliação prática da eficiência de cada método.

## Instituição
**PUCPR - Pontifícia Universidade Católica do Paraná**

## Disciplina
**Resolução de Problemas Estruturados em Computação**

## Professor
**Andrey Cabral Meira**

## Aluno
- Erick Maestri de Souza 

# Comparativo de Algoritmos de Ordenação

## Algoritmos Implementados
### 1. Comb Sort
Descrição: Evolução do Bubble Sort que utiliza um gap para comparar elementos distantes entre si

Característica: Elimina  elementos pequenos que estão posicionados no final do array

### 2. Gnome Sort
Descrição: Similar ao Insertion Sort, usando passos para frente e para trás

Característica: Eficiente para vetores quase ordenados

### 3. Bucket Sort
Descrição: Divide elementos em "baldes" e ordena cada balde separadamente

Característica: Excelente para dados uniformemente distribuídos

### 4. Bubble Sort com Flag
Descrição: Bubble Sort otimizado que para se nenhuma troca ocorrer

Característica: Eficiente em vetores quase ordenados

### 5. Selection Sort
Descrição: Seleciona repetidamente o menor elemento

Característica: Poucas movimentações, mas muitas comparações

### 6. Cocktail Sort
Descrição: Bubble Sort bidirecional que percorre o vetor em ambas as direções

Característica: Semelhante ao bubble sort, mas bidirecional

## Cenários de Teste
Vetor 1: Dados aleatórios 

Vetor 2: Dados ordenados crescentemente 

Vetor 3: Dados ordenados decrescentemente 


# Resultados

## Vetor 1

### Movimentos:
| Posição | Algoritmo             | Movimentos |
| ------- | -------------------- | ---------- |
| 1º      | Selection sort       | 54         |
| 2º      | Comb sort            | 66         |
| 3º      | Bubble sort c/ Flag  | 234        |
| 3º      | Gnome sort           | 234        |
| 3º      | Cocktail sort        | 234        |
| --      | Bucket sort          | 0 (desconsiderado) |

### Comparações:
| Posição | Algoritmo             | Comparações |
| ------- | -------------------- | ------------ |
| 1º      | Bucket sort          | 27           |
| 2º      | Comb sort            | 129          |
| 3º      | Cocktail sort        | 154          |
| 4º      | Gnome sort           | 174          |
| 5º      | Bubble sort c/ Flag  | 180          |
| 6º      | Selection sort       | 190          |

### Conclusão:
O Vetor 1 possuí dados aleatórios, algoritmos de troca adjacente (Bubble, Gnome, Cocktail) mostraram alta ineficiência em movimentos. 
Selection sort foi o mais econômico em trocas, enquanto Comb sort equilibrou bem ambos os critérios. 
Bucket sort foi o melhor em comparações, destacando sua vantagem para dados com domínio limitado.

---

## Vetor 2

### Movimentos:
| Posição | Algoritmo             | Movimentos |
| ------- | -------------------- | ---------- |
| 1º      | Comb sort            | 0          |
| 1º      | Gnome sort           | 0          |
| 1º      | Bubble sort c/ Flag  | 0          |
| 1º      | Selection sort       | 0          |
| 1º      | Cocktail sort        | 0          |
| --      | Bucket sort          | 0 (desconsiderado) |

### Comparações:
| Posição | Algoritmo             | Comparações |
| ------- | -------------------- | ------------ |
| 1º      | Bucket sort          | 15           |
| 2º      | Bubble sort c/ Flag  | 19           |
| 2º      | Cocktail sort        | 19           |
| 2º      | Gnome sort           | 19           |
| 5º      | Comb sort            | 110          |
| 6º      | Selection sort       | 190          |

### Conclusão:
O Vetor 2 está em ordem crescente , o que resultou em zero movimentos para todos os algoritmos.  
Algoritmos adaptativos (Bubble, Cocktail, Gnome) foram inteligentes ao encerrar com poucas comparações.
Comb sort e Selection sort ainda percorreram mais o vetor, mostrando que nem todos os algoritmos conseguem se beneficiar plenamente de vetores já ordenados.  
Bucket sort manteve sua eficiência com o menor número de comparações.

---

## Vetor 3

### Movimentos:
| Posição | Algoritmo             | Movimentos |
| ------- | -------------------- | ---------- |
| 1º      | Selection sort       | 30         |
| 2º      | Comb sort            | 54         |
| 3º      | Bubble sort c/ Flag  | 570        |
| 3º      | Gnome sort           | 570        |
| 3º      | Cocktail sort        | 570        |
| --      | Bucket sort          | 0 (desconsiderado) |

### Comparações:
| Posição | Algoritmo             | Comparações |
| ------- | -------------------- | ------------ |
| 1º      | Bucket sort          | 63           |
| 2º      | Comb sort            | 129          |
| 3º      | Selection sort       | 190          |
| 4º      | Bubble sort c/ Flag  | 190          |
| 4º      | Cocktail sort        | 190          |
| 6º      | Gnome sort           | 380          |

### Conclusão:
O Vetor 3 está em ordem decrescente, representando o pior caso para algoritmos baseados em trocas adjacentes, como Bubble, Cocktail e Gnome sort, que realizaram o máximo de movimentos.  
Selection sort e Comb sort mantiveram bom desempenho mesmo nesse cenário desfavorável, com poucas trocas e número razoável de comparações.  
Bucket sort novamente apresentou excelente eficiência, com baixo número de comparações, sendo o mais consistente em todos os cenários de comparação.
