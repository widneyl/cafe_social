import './styles.css'
import Header from '../../componentes/header';
function Principal() {
    return (
        <>
            <Header/>
            <div className='container-primary'>
                
                <div className='settings' id='box'>
                    <li>
                        <ul>Profile</ul>
                        <ul>Settings</ul>
                    </li>
                </div>

                <div className='timeline' id='box'>
                    <div className='post'>
                        <h2>Posting</h2>
                    </div>
                </div>

                <div className='notification' id='box'>
                    <li>
                        <ul>Posts</ul>
                        <ul>Friends</ul>
                    </li>
                </div>
                
            </div>
        </>
 
    );
}

export default Principal;