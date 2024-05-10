<h1 align="left">Desafio Curso Alura<br>Java: persistência de dados e consultas com Spring Data JPA</h1>

###

<p align="left">o desafio propõe a criação de uma aplicação que  seja possível cadastrar artistas e suas músicas e salvar esses dados no banco de dados, usando os recursos ensinados no curso.</p>

###

<h2 align="left">Como funciona</h2>

###

<p align="left">A aplicação depende de um banco postgreSQL os parâmetros do banco, como host, nome, usuário e senha são definido por variáveis de ambiente que estão d no arquivo application.properties<br>Com o banco configurado e acessível, ao rodar a aplicação são criadas as tabelas: artistas e musicas. É exibido o menu com as atualiazações contendo as opçÕes:<br><br>1 - Cadastrar artista<br>2 - Cadastrar música<br>3 - Listar músicas<br>4 - Buscar música por artistas<br>5 - Buscar por gênero<br>0 - Sair<br><br>Opção 1 um é solicitado o nome do artista\banda\dupla, ao digitar e esse já esteja cadastrado ele cancela o cadastro, caso contrário é feita a pergunta de qual gênero pertence, esse gênero é listado e deve ser um desses da lista, *Obs.: pode ser acrescentado adicionando mais gêneros no ENUM de genero, recomendo que seja ajustado antes de rodar a aplicação para que essas alterações persistam no banco*. Constinuando é solicitado definir a categorização de artista, banda ou solo.<br>Opção 2 é possível cadastrar músicas, é listado os artistas que estão gravados no banco, digite o nome do artista para cadastras tanto a música quanto o álbum referente a música. É possível cadastrar várias músicas em sequência e para sair desse menu digite 0.<br>Opção 3 lista todas as músicas cadastradas no banco.<br>Opção 4 lista as músicas associadas ao artista digitado<br>Opção 5 pode ser feita a busca de músicas por gênero, os mesmos são listados para ter a lista de quais estão cadastrados no banco.</p>

###
