import "./Main.css";
import { Outlet } from "react-router-dom";

function Main(): JSX.Element {
    return (
        <div className="Main">
        <h1>This is Main</h1>
          {
			//
          }
          <Outlet/>
			
        </div>
    );
}

export default Main;
