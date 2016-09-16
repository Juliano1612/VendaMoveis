# Sistema de Venda de Móveis a Varejo

##Descrição do Sistema

O software consiste em um sistema desktop que contém alguns CRUDs como: de clientes, funcionários e produtos. Além disso o sistema realiza a venda dos produtos em estoque para os clientes. Existem quatro tipos de usuários do sistema: gerente, vendedor, almoxarife e contabilidade. Cada um dos usuários possui uma série de funcionalidades específicas, ou até exclusivas, dependendo do seu cargo. O contador tem acesso a uma planilha de vendas da empresa e gastos gerais (salários, energia, fornecedores, etc). Com esses dados em mãos o contador pode gerar uma planilha de fluxo de caixa. O almoxarife possui acesso ao estoque da loja, podendo, pelo próprio sistema, realizar o envio de um pedido de reposição de estoque para o gerente. O vendedor tem acesso ao CRUD dos clientes e consulta de produtos, o que viabiliza que o mesmo possa realizar a venda. O gerente tem acesso a todos os CRUDs, às planilhas de fluxo de caixa e pedidos de reposição, além disso pode declarar gastos gerais que serão usados pelo contador futuramente. Como usuário com mais níveis de permissão, é o que pode realizar o maior número de funcionalidades no sistema. Além desses quatro níveis de usuário, foi criada também uma conta root que viabiliza a criação de novas contas de funcionários caso o haja algum problema com o banco de dados ou perda dos acessos principais. Como os funcionários da empresa são também os usuários do sistema, é necessário que haja um controle de login para que seja possível usá-lo. 

##Desenvolvedores
***
  * Anderson Sergio Oyama

  * Chen Po Hsiang		

  * Juliano Cézar Chagas Tavares

  * Rafael Cortez Sanches		
