import "./Main.css";
import { Outlet } from "react-router-dom";
import RoutingArea from "../../routingArea/routingArea";
function Main(): JSX.Element {
    return (
        <div className="Main">
          <RoutingArea/>
			<Outlet/>
			
        </div>
    );
}

export default Main;
