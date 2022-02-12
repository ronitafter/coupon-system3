import React from 'react';
import logo from './logo.svg';
import './App.css';

import RoutingArea from './routingArea/routingArea';
import Footer from './Components/layout/Footer/Footer';
import Main from './Components/layout/Main/Main';
import Menu from './Components/layout/Menu/Menu';
import Header from './Components/layout/Header/Header';
import Home from './Components/layout/Home/Home';
import Nav from './Components/layout/NavArea/Nav';
import { useState, useEffect } from "react";
import axios from 'axios';


function App() {
  // const resultArr = useState({}); //in brackets - state initial value
  //axios.get(url,()=>{
  //       setNumber(number+1);
  // }}));
  // const [joke, setJoke] = resultArr; //useState returns a pair of items in an array. The first is the value and the second is a function to set it
  /*
      (Destructring Array syntax - es6) Equivalent to:
      const number = resultArr[0];
      const setNumber = resultArr[1];
  */


  // console.log("react render");
  // useEffect(() => {
  //   console.log("running axios");
  //   setTimeout(() => axios.get("https://api.chucknorris.io/jokes/random").then((joke) => {
  //     console.log("joke returned from server");
  //     console.log(JSON.stringify(joke));
  //     setJoke(joke);
  //   }), 5000);
  // }, []);
  // return (
  //   <div className="Home">
  //     <p>HOME...</p>
  //     <button onClick={() => {
  //       console.log("button was clicked");
  //     }}>get joke!</button>
  //     <p>{JSON.stringify(joke)}</p>


  //   </div>
  // );
  return (
    <div className="App">
      <RoutingArea />
      <h1>App</h1>
      <Nav />
      <Main />
      <Header />
      <Menu />
      <Footer />
    </div>
  );
}

export default App;
