import "./Main.css";
import { Outlet } from "react-router-dom";
import { Link } from "react-router-dom";

function Main() {
  return (
    <div className="Main">
      <h1>This is Main</h1>


      <Outlet />

    </div>
  );
}

export default Main;
