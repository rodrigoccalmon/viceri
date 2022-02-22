-Utilizar Spring Boot para rodar a aplicação
-datasource.url: spring.datasource.url=jdbc:postgresql://localhost:5432/viceri
-Criar DATABASE no banco de dados com o nome "viceri".
-Após executar a aplicação pela primeira vez, o hibernate vai criar a base de dados e fazer as relações entre as tabelas.
-URL do swagger: http://localhost:8080/swagger-ui/index.html#/
______________

Endpoints para o front-end:

Cadastro de um usuário:
Método post: localhost:8080/api/usuarios/

_____________

Lista de usuários cadastrados:
método: GET
url: localhost:8080/api/usuarios/

____________

Login de um usuário cadastrado previamente:
método: POST
url: localhost:8080/api/login/

____________

Cadastro de uma tarefa:
método: POST
url: localhost:8080/api/tarefas/

___________

Listar TODAS as tarefas:
método: GET
url: localhost:8080/api/tarefas/todas

___________

Listar tarefas por USUÁRIO:
método: GET
url: localhost:8080/api/tarefas/filtrar/{idUsuario} - ex: localhost:8080/api/tarefas/filtrar/1

___________

Alterar a prioridade ou qualquer atributo da tarefa:
método: PUT
url: localhost:8080/api/tarefas/1 - obs: não precisa passar todos os campos novamente, apenas aquele que deseje alterar.

___________

Pesquisar por prioridade da tarefa: - alta, média ou baixa
método: GET
url: localhost:8080/api/tarefas/find?prioridade=Alta
|| 
localhost:8080/api/tarefas/find?prioridade=Media
|| 
localhost:8080/api/tarefas/find?prioridade=Baixa

___________

Deletar tarefa por id:
método: DELETE
url: localhost:8080/api/tarefas/{id} - exemplo: localhost:8080/api/tarefas/1

___________

atualizar status booleano de tarefa concluida
método: PUT
url: localhost:8080/api/tarefas/atualizartarefa/{id} - exemplo: localhost:8080/api/tarefas/atualizartarefa/1
Não precisa passar todos os campos, apenas alterar o atributo booleano de tarefaConcluida.
