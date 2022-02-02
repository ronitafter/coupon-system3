import { Route, Routes } from "react-router-dom";
import App from "../../App";
import Home from "../layout/Home/Home";
import PageNotFound from "../layout/pageNotFxound/PageNotFound";
import Login from "../Login/Login";
import AddCompany from "../usersArea/Admin/AddCompany";
import AddCustomer from "../usersArea/Admin/AddCustomer";
import Admin from "../usersArea/Admin/Admin";
import GetOneCompany from "../usersArea/Admin/GetOneCompany";
import GetOneCustomer from "../usersArea/Admin/GetOneCustomer";
import UpdateCompany from "../usersArea/Admin/UpdateCompany";
import UpdateCustomer from "../usersArea/Admin/UpdateCustomer";
import CouponsList from "../usersArea/CouponsArea/CouponsList";
import PurchaseCoupon from "../usersArea/Customer/PurchaseCoupon";
import "./routingArea.css";

function RoutingArea(){
    return (
        <div className="routingArea">
					<Routes>
             <Route path="/" element={<App/>} />
            <Route path="/home" element={<Home />} />
            <Route path="/login" element={Login}  />
            {/*Admin*/}
            {/*Admin/Company*/}
            <Route path="/admin" element={Admin}  />
            <Route path="/admin/AddCompany" element={AddCompany} />
            <Route path="/admin/GetOneCompany/:companyId" element={GetOneCompany}  />
             <Route path="/admin/UpdateCompany/:companyId" element={UpdateCompany}  />
            {/*Admin/Customer*/}
            <Route path="/admin/getOneCustomer/:customerId" element={GetOneCustomer}  />
            <Route path="/admin/AddCustomer" element={AddCustomer}  />
            <Route path="/admin/UpdateCustomer/:customerId" element={UpdateCustomer} />
            {/*Customer*/}
            <Route path="/customer/PurchaseCoupon" element={PurchaseCoupon} />
        
            <Route element={PageNotFound}/> 

{     
    }
            
            </Routes>
        </div>
    );
}

export default RoutingArea;
