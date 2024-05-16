import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import './App.css';

import Principal from './pages/principal';
import Sobre from './pages/sobre';
import Cadastro from './pages/cadastro';


function App() {''
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Principal/>}></Route>
        <Route path="/cadastro" element={<Cadastro/>}></Route>
        <Route path="/sobre" element={<Sobre/>}></Route>
        
      </Routes>
    </Router>
  );
}

export default App;
