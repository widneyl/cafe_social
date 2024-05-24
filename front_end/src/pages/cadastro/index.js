import './styles.css'
import Header from '../../componentes/header';
import { useState } from 'react';

function Cadastro() {
    
    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    return (
        <>
            <Header/>
            <div className='bloco-cadastro'>
                <form className='formulario'>
                    <h2>Cadastro</h2>
                    <input autoComplete='off' placeholder='Nome' type='text' value={nome} onChange={e => setNome(e.target.value)}/>
                    <input autoComplete='off' type='text' placeholder='Email' value={email} onChange={e => setEmail(e.target.value)}/>
                    <input autoComplete='off' type='password' placeholder='Senha' value={senha} onChange={e => setSenha(e.target.value)}/>
                    <button type='submit'>Entrar</button>
                </form>
            </div>
        </>
  
    );
}

export default Cadastro;