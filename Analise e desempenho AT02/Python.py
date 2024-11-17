import time

# Função para ler dados de um arquivo de texto
def ler_entrada(nome):
    arq = open(nome, 'r')
    dat = arq.readlines()
    arq.close()
    return dat

# Definir No
class No:
    def __init__(self, numero):
        self.numero = numero
        self.ponteiro = None

    def set_ponteiro(self, ponteiro):
        self.ponteiro = ponteiro

    def get_ponteiro(self):
        return self.ponteiro

    def get_numero(self):
        return self.numero

# Definir Lista
class L_Ligada:
    def __init__(self):
        self.cabeca = None

    def adicionar(self, numero, posicao):
        novo = No(numero)
        if self.cabeca == None:
            self.cabeca = novo
        else:
            atual = self.cabeca
            for i in range(posicao - 1):
                if atual.get_ponteiro() == None:
                    break
                atual = atual.get_ponteiro()
            novo.set_ponteiro(atual.get_ponteiro())
            atual.set_ponteiro(novo)

    def remover(self, numero):
        if self.cabeca == None:
            return -1
        if self.cabeca.get_ponteiro() == None:
            self.cabeca = None
            return -1
        atual = self.cabeca
        while atual.get_ponteiro() != None:
            if atual.get_ponteiro().get_numero() == numero:
                atual.set_ponteiro(atual.get_ponteiro().get_ponteiro())
                return 1
            atual = atual.get_ponteiro()

    def imprimir(self):
        lista = []
        atual = self.cabeca
        while atual != None:
            lista.append(atual.get_numero())
            atual = atual.get_ponteiro()
        print(lista)

# Função para processar os dados e gravar o tempo de execução
def processar_dados(caminho):
    start_time = time.time()  # Marcar o início do tempo

    dadosArquivo = ler_entrada(caminho)
    numeros = dadosArquivo[0].split()
    totalEntradas = int(dadosArquivo[1])
    comandos = []
    
    for i in range(2, totalEntradas + 2):
        comandos.append(dadosArquivo[i].split())
    
    lista = L_Ligada()
    for dat in numeros:
        lista.adicionar(int(dat), 999)
    
    for cmd in comandos:
        if cmd[0] == 'A':
            lista.adicionar(int(cmd[1]), int(cmd[2]))
        elif cmd[0] == 'R':
            lista.remover(int(cmd[1]))
        elif cmd[0] == 'P':
            lista.imprimir()

    end_time = time.time()  # Marcar o fim do tempo
    tempo_execucao = (end_time - start_time) * 1000  # Converter para milissegundos
    
    # Chamar a função para registrar o tempo de execução em um novo arquivo
    registrar_tempo_execucao(tempo_execucao)

# Função para registrar o tempo de execução em um arquivo
def registrar_tempo_execucao(tempo_execucao):
    with open("tempo_execucao.txt", 'a') as arq:  # Abrir em modo 'a' (append)
        arq.write(f"Tempo de execução: {tempo_execucao:.2f} ms\n")  # Adicionar nova linha

# Chamada da função para processar o arquivo
processar_dados("Testes/arq.txt")
