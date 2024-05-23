import './styles.css'
import Header from '../../componentes/header';
function Cadastro() {



    return (
        <>
            <Header/>
            <div className='bloco-cadastro'>
                <form className='formulario'>
                    <h2>Cadastro</h2>
                    <input autoComplete='off' type='nome' placeholder='Nome' value=""/>
                    <input autoComplete='off' type='text' placeholder='Email' value=""/>
                    <input autoComplete='off' type='password' placeholder='Senha' value=""/>
                    <button>Entrar</button>
                </form>
            </div>
        </>
  
    );
}

export default Cadastro;