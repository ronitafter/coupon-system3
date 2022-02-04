
import CustomLink from "../../../CustomLink/CustomLink";
import "./Nav.css";

function Nav(): JSX.Element {
    return (
        <div className="Nav">
            <nav>
                <CustomLink to="/home" >Home</CustomLink>
                <CustomLink to="/cats" >Cats</CustomLink>
                <CustomLink to="/about" >About</CustomLink>
                <CustomLink to="/donate" >Donate</CustomLink>
            </nav>
        </div>
    );
}

export default Nav;

        // <Link to="/home">Home</Link>|&nbsp;
		// <Link to="/dogs">Dogs</Link>|&nbsp;
        // <Link to="/about">About</Link>|{" "}
        // <Link to="/donate">Donate</Link>
    