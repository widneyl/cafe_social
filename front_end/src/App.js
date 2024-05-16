import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import './App.css';

import Principal from './pages/principal';

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Principal/>}></Route>
      </Routes>
    </Router>
  );
}

export default App;
