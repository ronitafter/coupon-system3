
import { Link } from "react-router-dom";
import "./Nav.css";

function Nav() {
    return (
        <div className="Nav">
            <nav>
                <Link to="/home" >Home</Link>
                <Link to="/login" >login</Link>
                <Link to="/coupons" >coupons</Link>
                <Link to="/?" >?</Link>
            </nav>
        </div>
    );
}

export default Nav;

        // <Link to="/home">Home</Link>|&nbsp;
		// <Link to="/dogs">Dogs</Link>|&nbsp;
        // <Link to="/about">About</Link>|{" "}
        // <Link to="/donate">Donate</Link>
    