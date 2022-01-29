import "./Main.css";
import { Outlet } from "react-router-dom";
import RoutingArea from "../../routingArea/routingArea";
function Main(): JSX.Element {
    return (
        <div className="Main">
        <h1>This is Main</h1>
          <RoutingArea/>
			<Outlet/>
			
        </div>
    );
}

export default Main;
