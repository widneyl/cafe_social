document.querySelector('#usuario-save-form').addEventListener('submit', (e) => {
    e.preventDefault();

    // objeto que vai ser salvo e transformado em json
    const usuario = {
        nome: e.target.nome.value,
        username: e.target.username.value,
        email: e.target.email.value,
        senha: e.target.senha.value,
        idade: e.target.idade.value,
    };

    // método fetch que vai interagir com a api
    fetch('http://localhost:8080/usuarios/cadastrar', {
        // tipo da requisição
        method: 'POST',
        // headers
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
    // convertendo para json
    .then(response => response.json())
    // pegando o estando da requisição, se foi bem sucessido ou não
    .then(usuario => {
        console.log('Success:', usuario);
        alert('Usuario cadastrado com sucesso!');
    })
    // se houver erro, o catch vai pegar e disparar uma mensagem
    .catch((error) => {
        console.error('Error:', error);
        alert('Ocorreu um erro ao cadastrar o gatuxo.');
    });


});