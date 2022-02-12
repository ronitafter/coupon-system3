import { Route, Routes } from "react-router-dom";
import Home from "../Components/layout/Home/Home";
import PageNotFound from "../Components/layout/pageNotFxound/PageNotFound";
import Login from "../Login/Login";
import AddCompany from "../usersArea/Admin/AddCompany";
import AddCustomer from "../usersArea/Admin/AddCustomer";
import Admin from "../usersArea/Admin/updateCompany";
import GetOneCompany from "../usersArea/Admin/GetOneCompany";
import GetOneCustomer from "../usersArea/Admin/GetOneCustomer";
//import UpdateCompany from "../usersArea/Admin/UpdateCompany";
import UpdateCustomer from "../usersArea/Admin/UpdateCustomer";
import CouponsList from "../usersArea/CouponsArea/CouponsList";
import PurchaseCoupon from "../usersArea/Customer/PurchaseCoupon";
import "./routingArea.css";

function RoutingArea() {
    return (
        <div className="routingArea">
            routingArea3
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/home" element={<Home />} />
                <Route path="/admin" element={<Admin />} />

                <Route path="/admin/GetOneCompany/:companyId" element={<GetOneCompany />} />

                <Route path="/admin/getOneCustomer/:customerId" element={<GetOneCustomer />} />

                <Route path="/admin/AddCustomer" element={<AddCustomer />} />

                <Route path="/admin/UpdateCustomer/:customerId" element={<UpdateCustomer />} />

                <Route path="/customer/PurchaseCoupon" element={<PurchaseCoupon />} />
                <Route element={<PageNotFound />} />
            </Routes>


        </div>
    );
}

export default RoutingArea;

/*
         <Route path="/admin/UpdateCompany/:companyId" element={<UpdateCompany/>} />
                <Route path="/" element={<App />} />

                
*/