import "./Menu.css";
import { Link } from "react-router-dom";

function Menu(): JSX.Element {
    return (
        <div className="Menu">
            Menu
            <Link to="/">Home</Link>
            <Link to="/login">Go to Login</Link>
        </div>
    );
}

export default Menu;
