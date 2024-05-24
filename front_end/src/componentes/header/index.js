import { Link } from 'react-router-dom'

import './styles.css'
import logo from '../../img/xicara-de-cafe.png'
function Header() {
    return (
        <header className='cabecalho'>
            <Link to="/"><img src={logo} alt="h"/></Link>
            <nav>
                <li><Link to="/cadastro">Cadastro</Link></li>
                <li><Link to="/sobre">Sobre</Link></li>
            </nav>
        </header>
    );
}

export default Header;