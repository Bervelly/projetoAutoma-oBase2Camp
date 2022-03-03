# projetoAutoma-oBase2Camp
O desafio consistia em criar cinco casos de testes automatizados para os cenários Mantis (ferramenta baseada na web que tem como principal função gerenciar bugs encontrados em um determinado sistema em teste), que o aluno julgar mais relevantes em termos de valor para o software.
Baseado na solicitação do projeto, e no meu entendimento do sistema Mantis, relacionei os seguintes casos de testes:

Caso 1
Título: Criar ocorrência de bug válida
Descrição: usuário conseguir criar uma ocorrência de bug com sucesso
Pré-condição: estar logado no sistema Mantis
Passo a passo (a fazer alterações antes de enviar): - clicar no campo Report Issue;
               - preencher o campo category;
               - preencher o campo reproducibility;
               - selecionar o campo severity;
               - selecionar bervelly.nobrega no campo assign to;
               - preencher o campo summary;
               - preencher o campo description.
               - clicar no botão Submit Report
               - ir para a página View Issues;
               - clicar no campo search e buscar o bug reportado pelo título descrito no Summary.
    
Resultado esperado: bug reportado exibido na lista de bugs reportados na página View Issues.

Caso 2
Título: Crias ocorrência de bug inválida
Descrição: usuário não consegue criar uma ocorrência de bug quando deixa de preencher um dos campos obrigatórios
Pré-condição: estar logado no sistema Mantis
Passo a passo (a fazer alterações antes de enviar): - clicar no campo Report Issue;
               - preencher todos os campos obrigatórios, exceto o Summary;
               - clicar no botão Submit Report
               
Resultado esperado: mensagem informando que um campo obrigatório estava vazio deve aparecer.

Caso 3
Título: Editar ocorrência de bug
Descrição: usuário conseguir editar uma ocorrência de bug já criada
Pré-condição: estar logado no sistema Mantis
Passo a passo (a fazer alterações antes de enviar): - ir para a página View Issues;
               - clicar no campo search e pesquisar o bug a ser editado pelo título descrito no Summary;
               - clicar na opção de edit;
               
Resultado esperado: aparece a tela de updating issue.

               - editar o campo summary com o novo valor a ser informado;
               - clicar no botão update information;
               - clicar no campo search e buscar o bug editado pelo novo título informado no Summary.
    
Resultado esperado: bug editado exibido na lista de bugs reportados na página View Issues com as novas informações.

Caso 4
Título: excluir ocorrência de bug
Descrição: usuário conseguir excluir uma ocorrência de bug com sucesso
Pré-condição: estar logado no sistema Mantis e ter um bug cadastro no sistema
Passo a passo (a fazer alterações antes de enviar): - ir para a página View Issues;
               - clicar no campo search e pesquisar o bug a ser excluido pelo título descrito no Summary;
               - clicar no checkbox para marcar o bug a ser excluido;
               - selecionar dentre a lista de opções a função delete;
               - clicar no botão ok.
    
Resultado esperado: deve mostrar tela para confirmar a exclusão da Issue.
               - clicar em delete issue;
               - clicar no campo search e buscar o bug excluido pelo título informado no Summary.
               
Resultado esperado: report de bug não ser encontrado na View Issues.



              
