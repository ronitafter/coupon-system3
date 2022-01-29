import React from 'react';
import logo from './logo.svg';
import './App.css';
import Footer from './Components/siteArea/Footer/Footer';
import Main from './Components/siteArea/Main/Main';
import Menu from './Components/siteArea/Menu/Menu';
import Header from './Components/siteArea/Header/Header';
import Home from './Components/siteArea/Home/Home';
import Nav from './Components/siteArea/NavArea/Nav';


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
