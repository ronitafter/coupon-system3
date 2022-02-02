import React from 'react';
import logo from './logo.svg';
import './App.css';
import Footer from './Components/layout/Footer/Footer';
import Main from './Components/layout/Main/Main';
import Menu from './Components/layout/Menu/Menu';
import Header from './Components/layout/Header/Header';
import Home from './Components/layout/Home/Home';
import Nav from './Components/layout/NavArea/Nav';


function App() {
  return (
    <div className="App">
      <h1>App</h1>
      {//<Nav/>
      }
      <Main/>
      <Header/>
      <Menu/>
      <Footer/>

      
    </div>
  );
}

export default App;
