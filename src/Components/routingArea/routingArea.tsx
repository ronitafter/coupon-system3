import { Route, Routes } from "react-router-dom";
import App from "../../App";
import Home from "../siteArea/Home/Home";
import CouponsList from "../usersArea/CouponsArea/CouponsList";
import "./routingArea.css";

function RoutingArea(): JSX.Element {
    return (
        <div className="routingArea">
					<Routes>
             <Route path="/" element={<App/>}/>
            <Route path="home" element={<Home />}/>
            <Route index element={<Home />}/>
            <Route path="cats" element={<CouponsList/>}/>

{           /* <Route path="cats/details/:id" element={<Details/>}/>
            <Route path="cats/new" element={<AddCoupon/>}/>
            <Route path="about" element={<About/>}/>*/
    }
            
            </Routes>
        </div>
    );
}

export default RoutingArea;
