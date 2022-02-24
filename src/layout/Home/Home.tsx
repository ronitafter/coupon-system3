import { Link } from "react-router-dom";
// import Nav from "../../moreArea/Nav/Nav";
import "./Home.css";
import { useState } from "react";
import axios from "axios";



function Home(): JSX.Element {
    const resultArr = useState(145); //in brackets - state initial value
    //axios.get(url,()=>{
    //       setNumber(number+1);
    // }}));
    const [number, setNumber] = resultArr; //useState returns a pair of items in an array. The first is the value and the second is a function to set it
    /*
        (Destructring Array syntax - es6) Equivalent to:
        const number = resultArr[0];
        const setNumber = resultArr[1];
    */
    return (
        <div className="Home">
            <p>HOME...</p>
            <button onClick={() => {
                setNumber(number + 1)
            }}>Add 1!</button>
            <p>{number}</p>


        </div>
    );
}

export default Home;
