<h1 align="center">
    <p>
        <b>Sticker Factory</b>
    </p>
    <p>
        <img src="https://img.shields.io/badge/-Em%20desenvolvimento-green?fstyle=for-the-badge&label=status" alt="status">
        <img src="https://img.shields.io/github/last-commit/tiaggofg/sticker-factory" alt="Último commit">
        <img src="https://img.shields.io/github/license/tiaggofg/sticker-factory?color=yellowgreen" alt="Licença">
    </p>
</h1>

Projeto desenvolvido durante a imersão Java da <a href="https://www.alura.com.br/"> alura </a>.Trata-se de um programa que consome um webservice semelhante a API top 250 filmes da IMDB e gera stickers para o whatsapp com base na sua avaliação.

<p align="center">
    <img src="resource/img/sticker-wpp.png">
<p>

<h3>
    <b>Funcioamento e desing do projeto</b>
</h3>

O projeto foi modelado a partir de um conceito de fábrica, sendo a classe ProductionCenter, do pacote factory, que executa o método main(). Veja que, é no centro de produção da fábrica que os recursos são utilizados para gerar as figurinhas.

A primeira tarefa executada pelo método main() é o acesso ao endpoint com os top 250 filmes da IMDB por meio do método estático getContent(). Esse método pertence a classe MyHttpClient e retorna um conteúdo json no formato de string.

Posteriormente, esse json é parseado e os dados dos filmes são extraídos por meio de um extrator. Os dados são utilizados para instanciar ImdbMovies em uma lista de Content. Desta forma, percebe-se que ImdbMovies é uma classe filha de Content.

Content é uma classe abstrata do pacote entertaimentContent. Essa classe foi criada com o intuíto de modelar o programa para consumir endpoints que tivessem três características em comum: poster, título e avaliação. Permitindo gerar figurinhas a partir de outros webservices, contanto que tenham essas informações.

Devido a isso, foi importante criar uma interface Extractor com o método data(), que extraí as informações do json. As classes que implementarem essa interface definirão como os dados vão ser extraídos, podendo ter extrator de dados de endpoints como IMDB, Marvel, Stars Wars, etc.

Após a instanciação dos ImdbMovies na lista de Content, o método estático producer(), da classe StickerGenerator, produz as figurinhas com base na nota, utilizando dessa para inserir as estrelas. Depois de criar os stickers na pasta /output, o programa imprime no terminal o título do filme que acabou de gerar o sitcker e a sua nota do IMDB com 1 casa decimal.

<p align="center">
    <img src="resource/img/cli-output.png">
</p>

<h3>
    <b>Tecnologias utilizadas</b>
</h3>

- Java SE 11
- Maven
- Visual Studio Code
- Eclipse