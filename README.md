# Detecção de faces usando Java e Open
> Detecção de faces







## Configuração de ambiente para desenvolvimento

Windows:

```sh
Baixe e instale o Java JDK na sua máquina.
Baixe e instale o NetBeans IDE 8.2.

```
## Configuração de ambiente para desenvolvimento OpenCV
```sh
Baixe o OpenCv e instale na sua máquina.
No seu projeto Java no NetBeans adicione um Jar/Pasta, procure pela pasta Opencv/build/opencv-320.jar

```

## Haarcascades OpenCv
```
Acesse a pasta opencv\sources\data\haarcascades.
Copie e cole a pasta Haarcascades em Pacotes de Códigos-fonte.
```
## Possíveis erros


	🚧 Problema para carregar biblioteca Core do Opencv🚧
    Correção: Na pasta do seu projeto, clique com o botão direito do mouse e clique em propriedades. Procure por "Executar" e em "opções de VM:" adicione o sequinte comando: "Djava.library.path="".
    Dentro das aspas você precisa adicionar o caminho do opencv_java320.dll do Opencv, que se encontra na pasta: opencv\build\java\x64. A versão da DLL é de acordo com a versão de da sua máquina, 32 ou 64bits.
