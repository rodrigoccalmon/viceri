# viceri
Estes são os endpoints para facilitar o trabalho do front-end:
obs: armazenamento de senhas criptografadas utilizando bcrypt.

Cadastro de um usuário:
método: POST
url: localhost:8080/api/usuarios/

exemplo: 
{
  "email": "rodrigo.ccalmon@gmail.com",
  "nome": "Rodrigo",
  "senha": "admin"
}
____________________

Lista de usuários cadastrados:
método: GET
url: localhost:8080/api/usuarios/
____________________

Login de um usuário cadastrado previamente:
método POST
url: localhost:8080/api/login/

exemplo: {
    "email": "rodrigo.ccalmon@gmail.com",
    "senha": "admin"
}

-> irá retornar o seguinte json: 
{
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ1NDcyNDczLCJleHAiOjE2NDU1NTg4NzN9.FOSMudqc40pW2M35X7Bqs0S2a0gH9vIQz75UwToN-vYzkwEE9al4BAfqIDabId6yanzlmGw7F1nSI36t4_nqiw",
    "usuario": {
        "id": 1,
        "nome": "Rodrigo",
        "email": "rodrigo.ccalmon@gmail.com",
        "senha": "$2a$10$yb/kpPsYtWdRTr8AynFP/eGYEn8WlcP.AEPdu7cLUHnhdAQ.PI3l2"
    }
}
____________________

Cadastro de uma tarefa:
método: POST
url: localhost:8080/api/tarefas/
exemplo: {
    
    "descricaoTarefa": "Entregar o teste da Viceri",
    "prioridade": "Alta",
    "usuario": {
        "id": 1,
        "nome": "rodrigo",
        "email": "rodrigo.ccalmon@gmail.com"
    }
}

___________________

Listar TODAS as tarefas:
método: GET
url: localhost:8080/api/tarefas/todas

___________________

Listar tarefas por USUÁRIO:
método: GET
url: localhost:8080/api/tarefas/filtrar/{idUsuario} - ex: localhost:8080/api/tarefas/filtrar/1

___________________

Alterar a prioridade ou qualquer atributo da tarefa:
método: PUT
url: localhost:8080/api/tarefas/1 - obs: não precisa passar todos os campos novamente, apenas aquele que deseje alterar.

__________________

Pesquisar por prioridade da tarefa: - alta, média ou baixa
método: GET
url: localhost:8080/api/tarefas/find?prioridade=Alta
|| 
localhost:8080/api/tarefas/find?prioridade=Media
|| 
localhost:8080/api/tarefas/find?prioridade=Baixa

__________________

Deletar tarefa por id:
método: DELETE
url: localhost:8080/api/tarefas/{id} - exemplo: localhost:8080/api/tarefas/1

__________________

atualizar status booleano de tarefa concluida
método: PUT
url: localhost:8080/api/tarefas/atualizartarefa/{id} - exemplo: localhost:8080/api/tarefas/atualizartarefa/1
Não precisa passar todos os campos, apenas alterar o atributo booleano de tarefaConcluida.
